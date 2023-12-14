package com.Ecomm_Backend.Storage;

import com.Ecomm_Backend.Model.Product;
import com.Ecomm_Backend.Model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class Storage {

    public static Map<String, User> userData = new HashMap<>();

    public static Map<String, List<Product>> productData = new HashMap<>();


}
