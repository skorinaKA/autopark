package com.example.autopark.service;

import com.example.autopark.entity.Auto;
import com.example.autopark.exception.AutoNotFoundException;
import com.example.autopark.repository.AutoRepository;
import com.example.autopark.repository.Auto_personnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Auto_ServiceImpl implements Auto_Service{

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private Auto_personnelRepository auto_personnelRepository;

    @Override
    public Iterable<Auto> listAuto() {
        return autoRepository.findAll();
    }

    @Override
    public Auto getAuto(Long auto_pk_id){
        Optional<Auto> optionalAuto=autoRepository.findById(auto_pk_id);
        if(optionalAuto.isPresent()) {
            return optionalAuto.get();
        }else {
            throw new AutoNotFoundException("Auto not Found");
        }
    }

    @Override
    public Auto setAuto(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    public Auto putAuto(Long id, Auto auto) {
        Auto auto1 = autoRepository.findById(id).get();
        auto1.setNum(auto.getNum());
        auto1.setColor(auto.getColor());
        auto1.setMark(auto.getMark());
        return autoRepository.save(auto1);
    }

    @Override
    public void deleteAuto(Long auto_pk_id) {
        autoRepository.deleteById(auto_pk_id);
    }

    @Override
    public void putNewAutoPersonnel(Long personnel_pk_id, Long auto_pk_id){
        Auto auto = autoRepository.findById(auto_pk_id).get();
        auto.setAuto_personnel(auto_personnelRepository.findById(personnel_pk_id).get());
        autoRepository.save(auto);
    }
}
