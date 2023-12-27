package com.Ecomm_Backend.Model;




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@ToString
@Document(collection = "User")
public class User implements Serializable {

    @MongoId
    @Indexed
    private String user_Id;
    @Email
    private String emailId;
    private boolean membership;
    @Size(min = 10,max = 10)
    private String phoneNum;
    private List<Product> productList;




}
