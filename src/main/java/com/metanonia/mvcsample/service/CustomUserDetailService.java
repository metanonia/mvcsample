package com.metanonia.mvcsample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
        //return NoOpPasswordEncoder.getInstance();
        return new Hmac512PasswordEncoder("salt");
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //String encrypted = BCrypt.hashpw("1234", BCrypt.gensalt());
        Hmac512PasswordEncoder hmac = new Hmac512PasswordEncoder("salt");
        String encrypted = hmac.encode("1234");
        return User.builder()
                .username(username)
                .password(encrypted)
                .roles("USER")
                .build();
    }
}
