package com.Ecomm_Backend.Security;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import java.security.SecureRandom;


@Configuration
public class SecurityConfiguration{


    @Value("${api.endpoint.baseurl}")
    private String baseUrl;


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(csrf->csrf.disable()).authorizeHttpRequests(request-> request
                .requestMatchers(baseUrl+"/register")
                .permitAll()
                .requestMatchers(baseUrl+"/getUser").authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


}
