package com.Ecomm_Backend.Repository;

import com.Ecomm_Backend.Model.User;
import com.Ecomm_Backend.Model.UserAuth;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface userAuthRepo extends MongoRepository<UserAuth,String> {


}
