package com.Ecomm_Backend.Model;




import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.List;


@Getter
@Setter
@ToString

public class User {




    private String id;
    private String name;

    private String emailId;

    private boolean membership;

    private String phoneNum;

    private String password;

    List<Product> productList;




}
