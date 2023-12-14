package com.Ecomm_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Map;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "ProductData")
public class Product {

    @MongoId
    private String product_Id;
    private String name;
    private String category;
    private Map<String, Long> size;
    private String color;
    private boolean pattern;
    private boolean plane;
    private String gender;
    private int price;

}
