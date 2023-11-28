package com.Ecomm_Backend.Controller;


import com.Ecomm_Backend.Model.User;
import com.Ecomm_Backend.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController("/")
public class Controller {

    @Autowired
    userService userServ;



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

}














