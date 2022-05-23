package com.example.autopark.service;

import com.example.autopark.repository.AutoRepository;
import com.example.autopark.repository.Auto_personnelRepository;
import com.example.autopark.repository.JournalRepository;
import com.example.autopark.repository.RoutesRepository;
import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class AutoPark_Service {

    @Autowired
    Auto_personnelRepository auto_personnelRepository;
    @Autowired
    AutoRepository autoRepository;
    @Autowired
    JournalRepository journalRepository;
    @Autowired
    RoutesRepository routesRepository;

    public List<Object> listOfAll(){
        List<Object> objectList = new ArrayList<>();
        objectList.add(auto_personnelRepository.findAll());
        objectList.add(autoRepository.findAll());
        objectList.add(journalRepository.findAll());
        objectList.add(routesRepository.findAll());
        return objectList;
    }
}
