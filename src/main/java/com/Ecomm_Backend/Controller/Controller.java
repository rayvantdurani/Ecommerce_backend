package com.Ecomm_Backend.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {

    @GetMapping("/home")
    public String getHome()
    {
        return "Hello";
    }
}
