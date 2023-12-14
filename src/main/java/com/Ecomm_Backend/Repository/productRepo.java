package com.Ecomm_Backend.Repository;

import com.Ecomm_Backend.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo extends MongoRepository<Product,Long> {
}
