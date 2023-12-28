package com.Ecomm_Backend.Controller;


import com.Ecomm_Backend.Model.User;
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
    userRepo userrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user)
    {
        User savedUser = null;
        ResponseEntity response=null;
        try
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            savedUser=userrepo.save(user);
            if(null!=savedUser.getUser_Id()) {
                response = ResponseEntity.status(HttpStatus.CREATED).body("User Created");
            }
        }
        catch(Exception e)
        {
            response=ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An Exception Occured Due to "+e.getMessage());
        }

        return response;
    }

}
