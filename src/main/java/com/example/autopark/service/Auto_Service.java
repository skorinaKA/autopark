package com.example.autopark.service;

import com.example.autopark.entity.Auto;

public interface Auto_Service {
    Iterable<Auto> listAuto();
    Auto getAuto(Long auto_pk_id);
    Auto setAuto(Auto auto);
    Auto putAuto(Long id, Auto auto);
    void deleteAuto(Long auto_pk_id);
    void putNewAutoPersonnel(Long personnel_pk_id, Long auto_pk_id);
}
