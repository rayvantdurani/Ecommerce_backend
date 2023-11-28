package com.Ecomm_Backend.Controller;


import com.Ecomm_Backend.Database.UserRepo;
import com.Ecomm_Backend.Model.Product;
import com.Ecomm_Backend.Model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController("/")
public class Controller {

    @Autowired
    public UserRepo userR;

    @PostMapping("/save")
 public String saveUser(@RequestBody User user)
 {
        if(!checkifexists(user))
        {
           this.userR.userSave(user);
            return "Success";
        }
        else {
            return "Fail";
        }
 }

    private boolean checkifexists(User user) {

       return  this.userR.querybyId(user);

    }


    @GetMapping("/find")
    public User findUser(@RequestBody User user)
    {
        String username=user.getName();
        String Id=user.getId();
      return  userR.getUser(username,Id);
    }


    @GetMapping("/delete")
    public String deleteUser(@RequestBody User user)
    {
        String key = user.getName()+user.getId();
        return userR.delete(key);
    }

    @GetMapping("/all")
   public Map<String,User> getUsersList()
   {
       return userR.getUserList();
   }











}
