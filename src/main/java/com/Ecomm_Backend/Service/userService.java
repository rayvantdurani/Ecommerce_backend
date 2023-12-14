package com.Ecomm_Backend.Service;

import com.Ecomm_Backend.Model.Product;
import com.Ecomm_Backend.Model.User;
import com.Ecomm_Backend.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Service
public class userService {

    @Autowired
    private userRepo userR;

    public User createUser(User user)
    {
        try
        {
         return  userR.save(user);
        }catch (Exception e)
        {
            return null;
        }
    }


    public User upateUserInfo(User user) {
        try
        {
           return userR.save(user);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public List<Product> addToUserCart(String user_Id, List<Product> prodList) {
        User current_User = userR.findById(user_Id)
                .orElseThrow();

        List<Product> userCart = current_User.getProductList();
        if (userCart == null) {
            userCart = new ArrayList<>();
            current_User.setProductList(userCart); // Assuming there's a setter for productList
        }

        // Add all products to the user's cart
        userCart.addAll(prodList);

        // Save the updated user
        User updatedUser = userR.save(current_User);

        // Return the updated list of products in the user's cart
        return updatedUser.getProductList();

    }
    private Optional<User> getUserById(String user_Id)
    {
      return  userR.findById(user_Id);
    }

    public ResponseEntity<List<User>> getAllUser() {
        List<User> usersList = userR.findAll();

        if(usersList.isEmpty()) {
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(usersList);
        }
}
