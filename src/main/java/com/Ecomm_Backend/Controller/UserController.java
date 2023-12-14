package com.Ecomm_Backend.Controller;


import com.Ecomm_Backend.Model.Product;
import com.Ecomm_Backend.Model.User;
import com.Ecomm_Backend.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController("/")
public class UserController {

    @Autowired
    userService userServ;

    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getAllUser()
    {
        ResponseEntity<List<User>> userList = userServ.getAllUser();
        if(null!=userList)
        {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand(userList).toUri();

            return userList;
        }

        return ResponseEntity.noContent().build();
    }



    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody User user)
    {

       User savedUser = userServ.createUser(user);
        URI location =null;
       if(null!=savedUser) {
           location = ServletUriComponentsBuilder
                   .fromCurrentRequest()
                   .path("/{name}")
                   .buildAndExpand(savedUser.getName()).toUri();
           return ResponseEntity.created(location).build();
       }
       return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody User user)
    {
        User updatedUser = userServ.upateUserInfo(user);
        URI location =null;
        if(null!=updatedUser)
        {
            location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{user}")
                    .buildAndExpand(updatedUser.getName())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/addToCart/{user_Id}")
    public ResponseEntity<List<Product>> addToUserCart(@PathVariable String user_Id,@RequestBody List<Product> prodList)
    {
        List<Product> userCart = userServ.addToUserCart(user_Id,prodList);
        if(null!=userCart) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.badRequest().build();


    }






}














