package com.Ecomm_Backend.Service;

import com.Ecomm_Backend.Exception.ResourceNotFoundException;
import com.Ecomm_Backend.Model.Product;
import com.Ecomm_Backend.Repository.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService {

    @Autowired
    productRepo productR;


    public Product saveProduct(Product product) {

        try {
            return productR.save(product);
        }catch(Exception e)
        {
            return null;
        }
    }

    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> prodList = productR.findAll();

        if (prodList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(prodList);
    }


    public Product updateProduct(Long productId, Product productDetails) {
        Product existingProduct = productR.findById(productId)
                .orElseThrow();

        // Update the existing product with new details
        existingProduct.setName(productDetails.getName());
        existingProduct.setProduct_Id(productDetails.getProduct_Id()); // Assuming you have a setter for Product_Id
        existingProduct.setGender(productDetails.getGender());
        existingProduct.setColor(productDetails.getColor());
        existingProduct.setPlane(productDetails.isPlane());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setPattern(productDetails.isPattern()); // Assuming pattern is a boolean field
        existingProduct.setPrice(productDetails.getPrice());

        // Save the updated product
        return productR.save(existingProduct);
    }

    private Optional<Product> getProductById(Long productId) {
      return productR.findById(productId);

    }
}
