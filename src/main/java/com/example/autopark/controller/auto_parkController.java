package com.example.autopark.controller;

import com.example.autopark.entity.Users;
import com.example.autopark.handler.UserService;
import com.example.autopark.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class auto_parkController {

    private AutoPark_Service autoPark_service;
    private UserDetailsService userDetailsService;
    private UserService userService;

    @Autowired
    public void setUserDetails(UserDetailsService userDetailsService){
        this.userDetailsService=userDetailsService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }

    @Autowired
    private void setAutoPark(AutoPark_Service autoPark_service){
        this.autoPark_service=autoPark_service;
    }

    @GetMapping("/hello")
    public ModelAndView sayhello(){
        ModelAndView model = new ModelAndView();
        String message = "ПассажирАвтоТранс";
        model.addObject("message", message);
        model.setViewName("index");
        return model;
    }

    @GetMapping("/get/all")
    public Object getAutoPark(){
        return autoPark_service.listOfAll();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDetails findUser(@RequestBody Users users){
        return userDetailsService.loadUserByUsername(users.getLogin());
    }

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ModelAndView findUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user")
                .setViewName("Users");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_up/", method = RequestMethod.POST)
    public Users createUser(Users users){
        return userService.create(users);
    }

}
