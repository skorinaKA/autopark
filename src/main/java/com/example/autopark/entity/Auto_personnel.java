package com.example.autopark.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Auto_personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auto_personnel_pk_id")
    private Long auto_personnel_pk_id;

    private String first_name;

    private String last_name;

    private String pather_name;

    public Auto_personnel(){

    }

    public Auto_personnel(String first_name, String last_name, String pather_name) {
        //this.auto_personnel_pk_id = auto_personnel_pk_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.pather_name = pather_name;
    }

    public Long getAuto_personnel_pk_id() {
        return auto_personnel_pk_id;
    }

    public void setAuto_personnel_pk_id(Long auto_personnel_pk_id) {
        this.auto_personnel_pk_id = auto_personnel_pk_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPather_name() {
        return pather_name;
    }

    public void setPather_name(String pather_name) {
        this.pather_name = pather_name;
    }

    @Override
    public String toString() {
        return "Auto_personnel\n{" +
                "auto_personnel_pk_id=" + auto_personnel_pk_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", pather_name='" + pather_name + '\'' +
                '}';
    }
}
