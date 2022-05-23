package com.example.autopark.service;

import com.example.autopark.entity.Auto_personnel;
import com.example.autopark.exception.Auto_personnelNotFoundException;
import com.example.autopark.repository.Auto_personnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Autopersonnel_ServiceImpl implements Autopersonnel_Service{

    @Autowired
    private Auto_personnelRepository auto_personnelRepository;

    @Override
    public Iterable<Auto_personnel> listAuto_personnel() {
        return auto_personnelRepository.findAll();
    }

    @Override
    public Auto_personnel getAuto_personnel(Long auto_personnel_pk_id) {
        Optional<Auto_personnel> optionalAuto_personnel=auto_personnelRepository.findById(auto_personnel_pk_id);
        if(optionalAuto_personnel.isPresent()){
            return optionalAuto_personnel.get();
        }else {
            throw new Auto_personnelNotFoundException("Auto_personnel not found");
        }
    }

    @Override
    public Auto_personnel setAuto_personnel(Auto_personnel auto_personnel) {
        return auto_personnelRepository.save(auto_personnel);
    }

    @Override
    public Auto_personnel putAuto_personnel(Long id, Auto_personnel auto_personnel) {
        Auto_personnel auto_personnel1 = auto_personnelRepository.findById(id).get();
        auto_personnel1.setFirst_name(auto_personnel.getFirst_name());
        auto_personnel1.setLast_name(auto_personnel.getLast_name());
        auto_personnel1.setPather_name(auto_personnel.getPather_name());
        return auto_personnelRepository.save(auto_personnel1);
    }

    @Override
    public void deleteAuto_personnel(Long auto_personnel_pk_id) {
        auto_personnelRepository.deleteById(auto_personnel_pk_id);
    }

}
