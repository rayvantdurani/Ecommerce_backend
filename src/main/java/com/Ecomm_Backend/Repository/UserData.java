package com.Ecomm_Backend.Repository;

import com.Ecomm_Backend.Database.UserRepo;
import com.Ecomm_Backend.Model.User;

import com.Ecomm_Backend.Storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
public class UserData implements UserRepo {



    //Save User API
    @Override
    public User userSave(User userinfo) {

        String key = ""+userinfo.getId()+userinfo.getName();

        if(Storage.userData.containsKey(key))
        {
            return null;
        }
        else {
            Storage.userData.put(key,userinfo);
            return userinfo;
        }

    }

    @Override
    public boolean querybyId(User user) {
        String key = ""+user.getId()+user.getName();
        if(Storage.userData.isEmpty())
        {
          return false;
        } else if (Storage.userData.containsKey(key)) {
            return true;
        }
        else
        {
            return false;
        }
    }



    public User getUser( String userName, String id)
    {
        String filterUserKey = id+userName;

        if(Storage.userData.containsKey(filterUserKey))
        {
            return Storage.userData.get(filterUserKey);
        }
        else {
            return null;
        }
    }

    @Override
    public String delete(String userKey) {

        if(null!=userKey)
        {
            Storage.userData.remove(userKey);
            return "Sucess User Deleted";
        }
        else {
            return "No User";
        }
    }

    @Override
    public Map<String, User> getUserList() {
        return Storage.userData;
    }


}
