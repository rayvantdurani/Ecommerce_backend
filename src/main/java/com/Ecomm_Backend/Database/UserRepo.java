package com.Ecomm_Backend.Database;

import com.Ecomm_Backend.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public interface UserRepo{


     User userSave(User useinfo);

     boolean querybyId(User user);

     User getUser(String userName,String id);

     String delete(String userKey);


     Map<String, User> getUserList();
}
