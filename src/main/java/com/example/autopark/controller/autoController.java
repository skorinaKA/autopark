package com.example.autopark.controller;

import com.example.autopark.entity.Auto;
import com.example.autopark.service.Auto_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auto")
public class autoController {

    private Auto_Service auto_service;

    @Autowired
    public void setAuto(Auto_Service auto_service){
        this.auto_service =auto_service;
    }

    @GetMapping("/hello")
    public ModelAndView sayhello(){
        ModelAndView model = new ModelAndView();
        String message = "Auto";
        model.addObject("message", message);
        model.setViewName("index");
        return model;
    }

    @PostMapping(value = "/")
    public Auto addAuto( Auto auto){
        return auto_service.setAuto(auto);
    }

    @GetMapping(value = "/get/")
    public ModelAndView getAuto(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auto",auto_service.getAuto((long)id)).setViewName("AutoList");
        return modelAndView;
    }

    @GetMapping(value = "/get/{id}")
    public ModelAndView getauto(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auto",auto_service.getAuto((long)id)).setViewName("AutoList");
        return modelAndView;
    }

    @GetMapping(value = "/get/all")
    public ModelAndView getAllAuto(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auto", auto_service.listAuto())
                .setViewName("AutoList");
        return modelAndView;
    }

    @PostMapping("/put/")
    public Auto update(@RequestParam("id") int id, Auto auto){
        return auto_service.putAuto((long)id,auto);
    }

    @PostMapping("/putPersonnel/")
    public void Update(@RequestParam("id") int id, @RequestParam("id1") int id1){
        auto_service.putNewAutoPersonnel((long)id1,(long)id);
    }

    @PostMapping(value = "/delete/")
    public void deleteAuto(@RequestParam("id") int id){
        auto_service.deleteAuto((long)id);
        //return ("Delete /" + id + " succes!");
    }

}
