package com.Ecomm_Backend.Database;

import com.Ecomm_Backend.Model.Product;

public interface ProductRepo {

    public String saveProduct(String key,Product productItem);
}
