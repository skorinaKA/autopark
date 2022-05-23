package com.example.autopark.service;

import com.example.autopark.entity.Auto_personnel;

public interface Autopersonnel_Service {
    Iterable<Auto_personnel> listAuto_personnel();
    Auto_personnel getAuto_personnel(Long auto_personnel_pk_id);
    Auto_personnel setAuto_personnel(Auto_personnel auto_personnel);
    Auto_personnel putAuto_personnel(Long id, Auto_personnel auto_personnel);
    void deleteAuto_personnel(Long auto_personnel_pk_id);
}
