package com.Ecomm_Backend.Controller;

import com.Ecomm_Backend.Exception.ResourceNotFoundException;
import com.Ecomm_Backend.Model.Product;
import com.Ecomm_Backend.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController("/product")
public class ProductContoller {

    @Autowired
    productService productServ;

    @PostMapping("/addProduct")
    public ResponseEntity<Object> addProduct(@RequestBody Product product)
    {
        Product savedProduct = productServ.saveProduct(product);
        URI location = null;
        if(null!=savedProduct)
        {
            location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{product_Id}")
                    .buildAndExpand(savedProduct.getProduct_Id()).toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{product_Id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long product_Id, @RequestBody Product product) {
        try {
            Product updatedProduct = productServ.updateProduct(product_Id, product);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(updatedProduct.getProduct_Id())
                    .toUri();

            return ResponseEntity.created(location).body(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/stock")
    public ResponseEntity<List<Product>> getStock()
    {
        return productServ.getAllProducts();
    }






}
