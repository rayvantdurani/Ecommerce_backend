package com.Ecomm_Backend.Authentication;


import com.Ecomm_Backend.Repository.UserAuthInterface;
import com.Ecomm_Backend.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfo implements UserDetailsService {


    @Autowired
    UserAuthInterface userAuth;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String userName = null;
        String password = null;
        List<GrantedAuthority> authorities = null;

        List<com.Ecomm_Backend.Model.UserAuth> userList = userAuth.findbyuser_Id(username);
        if(userList.isEmpty())
        {
            throw new UsernameNotFoundException("User Details Not Found"+username);
        }
        else {
            userName=userList.get(0).getUserName();
            password=userList.get(0).getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(userList.get(0).getRole()));
        }

        return new User(userName,password,authorities);
    }
}
