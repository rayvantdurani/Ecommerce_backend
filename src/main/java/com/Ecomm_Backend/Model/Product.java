package com.Ecomm_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;


@Getter
@Setter
@ToString
@AllArgsConstructor
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
