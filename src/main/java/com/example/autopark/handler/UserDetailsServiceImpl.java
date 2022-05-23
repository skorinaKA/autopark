package com.example.autopark.handler;

import com.example.autopark.entity.Users;
import com.example.autopark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        /*System.out.println("FINDING USER!!!!!!!!!!!!!!!!!! " + login);
        //Users userscheck = userRepository.findByLogin(login).orElseThrow();
        //System.out.println("FINDING USER!!!!!!!!!!!!!!!!!! " + userscheck.getLogin() + userscheck.getPassword());
        for(Users users: userRepository.findAll()){
            System.out.println("FINDING USER!!!!!!!!!!!!!!!!!! " + users.getLogin() + users.getPassword());
        }*/


        Users user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        //System.out.println("FIND IT!!!!!!!!!!!!!!!!!!");
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}