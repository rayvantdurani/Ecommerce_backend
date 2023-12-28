package com.Ecomm_Backend.Repository;

import com.Ecomm_Backend.Model.User;
import com.Ecomm_Backend.Model.UserAuth;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userRepo extends MongoRepository<User,String> {





}
