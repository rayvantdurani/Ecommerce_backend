package com.Ecomm_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "ProductData")
public class Product {

    private String name;
    private String category;
    private Map<String, Long> size;
    private String color;
    private String pattern;
    private String topWear;
    private String bottomWear;
    private String gender;

}
