package com.Ecomm_Backend.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;



@Configuration

public class SecurityConfiguration{



//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(authorizationHttpRequests ->authorizationHttpRequests
//                        //.requestMatchers(HttpMethod.GET,"/api/").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/api/v1/create").permitAll()
//                        .anyRequest().permitAll())
//                .csrf(csrf->csrf.disable())
//                .build();
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder(10);
//    }






}
