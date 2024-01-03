package com.Ecomm_Backend.Security;

import com.Ecomm_Backend.Model.UserAuth;
import com.Ecomm_Backend.Repository.UserAuthInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EcommBackAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private UserAuthInterface userAuthInterface;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;




    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<UserAuth> userDetail =userAuthInterface.findbyuser_Id(userName);
        if(!userDetail.isEmpty())
        {
            if(passwordEncoder.matches(password,userDetail.get(0).getPassword()))
            {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(userDetail.get(0).getRole()));
                return (new UsernamePasswordAuthenticationToken(userName,password,authorities));
            }else {
                throw new BadCredentialsException("Bad Credentials");
            }
        }else {
            throw new BadCredentialsException("No User Found ");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
