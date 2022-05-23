package com.example.autopark.controller;

import com.example.autopark.entity.Routes;
import com.example.autopark.service.Routes_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/routes")
public class routesController {

    private Routes_Service routesService;

    @Autowired
    public void setRoutesService(Routes_Service routesService){
        this.routesService =routesService;
    }

    @GetMapping("/hello")
    public ModelAndView sayhello(){
        ModelAndView model = new ModelAndView();
        String message = "Routes";
        model.addObject("message", message);
        model.setViewName("index");
        return model;
    }

    @PostMapping(value = "/")
    public Routes addRoutes(Routes routes){
        return routesService.setRoutes(routes);
    }

    @GetMapping(value = "/get/{id}")
    public ModelAndView getroutes(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Routes",routesService.getRoutes((long)id)).setViewName("RoutesList");
        return modelAndView;
    }

    @GetMapping(value = "/get/")
    public ModelAndView getRoutes(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Routes",routesService.getRoutes((long)id)).setViewName("RoutesList");
        return modelAndView;
    }

    @GetMapping(value = "/get/all")
    public ModelAndView getAllRoutes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Routes", routesService.listRoutes())
                .setViewName("RoutesList");
        return modelAndView;
    }

    @PostMapping("/put/")
    public Routes update(@RequestParam("id") int id, Routes routes){
        return routesService.putRoutes((long)id,routes);
    }

    @PostMapping(value = "/delete/")
    public void deleteRoutes(@RequestParam("id") int id){
        routesService.deleteRoutes((long)id);
        //return ("Delete /" + id + " succes!");
    }

}
