package com.Ecomm_Backend.Model;




import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;


@Getter
@Setter
@ToString
@Document(collection = "User")
public class User {

    @MongoId
    private String id;

    @Indexed(unique = true)
    private String name;


    private String emailId;

    private boolean membership;

    private String phoneNum;

    private String password;

    List<Product> productList;




}
