package com.Ecomm_Backend.Model;

import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "UserAuthDetails")
public class UserDetailsAuth {

    @MongoId
    @Indexed
    private String user_Id;
    @Size(min = 4 , max = 20)
    private String userName;
    @Size(min = 8,max = 18)
    private String password;

}
