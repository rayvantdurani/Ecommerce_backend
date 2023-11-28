package com.Ecomm_Backend.Service;

import com.Ecomm_Backend.Model.User;
import com.Ecomm_Backend.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

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







}
