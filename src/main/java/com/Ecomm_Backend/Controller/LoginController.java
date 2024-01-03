package com.Ecomm_Backend.Controller;



import com.Ecomm_Backend.Model.User;
import com.Ecomm_Backend.Model.UserAuth;
import com.Ecomm_Backend.Repository.UserAuthInterface;
import com.Ecomm_Backend.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint.baseurl}")
public class LoginController {


    @Autowired
    UserAuthInterface userAuthInterface;

    @Autowired
    userRepo  userrepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserAuth user)
    {
        UserAuth savedUserAuth = null;
        User userDetailsDB = null;
        ResponseEntity response=null;
        try
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            savedUserAuth= userAuthInterface.save(user);
            setUserDetails(user);
            if(!savedUserAuth.getUserName().isEmpty()) {
                response = ResponseEntity.status(HttpStatus.CREATED).body("User Created");
            }
        }
        catch(Exception e)
        {
            response=ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An Exception Occured Due to "+e.getMessage());
        }

        return response;
    }


    private void setUserDetails(UserAuth user)
    {
        User userData = new User();
        userData.setUserName(user.getUserName());
        userData.setRole(user.getRole());
        userData.setMembership(false);
        userData.setPhoneNum(null);
        userData.setEmailId(null);
        userrepo.save(userData);
    }

}
