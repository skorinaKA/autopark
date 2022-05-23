package com.example.autopark.controller;


import com.example.autopark.entity.Journal;
import com.example.autopark.service.Journal_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.ParseException;

@RestController
@RequestMapping("/journal")
public class journalController {

    private Journal_Service journalService;

    @Autowired
    public void setJournalService(Journal_Service journalService){
        this.journalService =journalService;
    }

    @GetMapping("/hello")
    public ModelAndView sayhello(){
        ModelAndView model = new ModelAndView();
        String message = "Journal";
        model.addObject("message", message);
        model.setViewName("index");
        return model;
    }

    @PostMapping(value = "/")
    public Journal addJournal(@RequestParam("timestamp")String timestamp,
                              @RequestParam("timestamp1") String timestamp1) throws ParseException {
        return journalService.setJournal(timestamp,timestamp1);
    }

    @PostMapping(value = "/add_auto/")
    public void addAuto(@RequestParam("id")int id, @RequestParam("id1")int id1){
        journalService.putNewAuto((long)id,(long)id1);
    }

    @PostMapping(value = "/add_route/")
    public void addRoute(@RequestParam("id") int id, @RequestParam("id1") int id1){
        journalService.putNewRoute((long)id,(long)id1);
    }

    @GetMapping(value = "/get")
    public ModelAndView getjournal(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Journal",journalService.getJournal((long)id)).setViewName("JournalList");
        return modelAndView;
    }

    @GetMapping(value = "/get/all")
    public ModelAndView getJournal(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Journal", journalService.listJournal())
                .setViewName("JournalList");
        return modelAndView;
    }

    @PostMapping("/put/")
    public Journal update(@RequestParam("id") int id, @RequestParam("timestamp") String timestamp,
                          @RequestParam("timestamp1") String timestamp1) throws ParseException{
        return journalService.putJournal((long)id,timestamp,timestamp1);
    }

    @PostMapping(value = "/delete")
    public void deleteJournal(@RequestParam("id") int id){
        journalService.deleteJournal((long)id);
        //return ("Delete /" + id + " succes!");
    }

}
