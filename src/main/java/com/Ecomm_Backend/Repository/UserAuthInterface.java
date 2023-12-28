package com.Ecomm_Backend.Repository;

import com.Ecomm_Backend.Model.UserAuth;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserAuthInterface extends MongoRepository<UserAuth,String> {

    @Query("{'userName' : ?0}")
    List<UserAuth> findbyuser_Id(String user_Id);
}
