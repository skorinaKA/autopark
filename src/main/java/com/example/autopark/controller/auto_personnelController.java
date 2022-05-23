package com.example.autopark.controller;
import com.example.autopark.entity.Auto_personnel;
import com.example.autopark.service.Autopersonnel_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auto_personnel")
public class auto_personnelController {

    private Autopersonnel_Service autopersonnel_service;

    @Autowired
    public void setAuto_personnel(Autopersonnel_Service autopersonnel_service){
        this.autopersonnel_service =autopersonnel_service;
    }

    @GetMapping(value = {"/hello"})
    public ModelAndView sayhello(){
        ModelAndView model = new ModelAndView();
        String message = "AutoPersonnel";
        model.addObject("message", message);
        model.setViewName("index");
        return model;
    }

    @PostMapping(value = "/")
    public Auto_personnel addAuto_Personnel(Auto_personnel auto_personnel){
        return autopersonnel_service.setAuto_personnel(auto_personnel);
    }

    @GetMapping(value = "/get/{id}")
    public ModelAndView getAuto_Personnel(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auto_personnel", autopersonnel_service.getAuto_personnel((long)id))
                .setViewName("Auto_PersonnelList");
        return modelAndView;
    }

    @GetMapping(value = "/get/")
    public ModelAndView getAutoPersonnel(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auto_personnel", autopersonnel_service.getAuto_personnel((long)id))
                .setViewName("Auto_PersonnelList");
        return modelAndView;
    }

    @GetMapping(value = "/get/all")
    public ModelAndView getAllAuto_Personnel(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auto_personnel", autopersonnel_service.listAuto_personnel())
                .setViewName("Auto_PersonnelList");
        return modelAndView;
    }

    @PostMapping("/put/")
    public Auto_personnel update(@RequestParam("id") int id, Auto_personnel auto_personnel){
        return autopersonnel_service.putAuto_personnel((long)id,auto_personnel);
    }

    @PostMapping(value = "/delete/")
    public void deleteAuto_Personnel(@RequestParam("id") int id){
        //System.out.println(id);
        autopersonnel_service.deleteAuto_personnel((long)id);
        //return ("Delete /" + id + " succes!");
    }
}
