package com.Ecomm_Backend.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.Map;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "ProductData")
public class Product implements Serializable {

    @MongoId
    private String product_Id;

    @NonNull
    private String name;
    private String category;
    private Map<String, Long> size;
    private String color;
    private boolean pattern;
    private boolean plane;
    private String gender;
    private int price;

}
