package com.example.autopark.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auto_pk_id")
    private Long auto_pk_id;

    private String num;

    private String color;

    private String mark;

    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long personnel_id;

    @ManyToOne/*(optional=false,cascade=CascadeType.MERGE)*/
    @JoinColumn(name = "personnel_id",insertable = false,updatable = false)
    private Auto_personnel auto_personnel;

    public Auto(){
        super();
    }

    public Auto(String num, String color, String mark, Auto_personnel auto_personnel) {
        //this.auto_pk_id = auto_pk_id;
        this.num = num;
        this.color = color;
        this.mark = mark;
        this.auto_personnel = auto_personnel;
        this.personnel_id = auto_personnel.getAuto_personnel_pk_id();
    }

    public Long getAuto_pk_id() {
        return auto_pk_id;
    }

    public void setAuto_pk_id(Long auto_pk_id) {
        this.auto_pk_id = auto_pk_id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMark() {
        return mark;
    }

    public Long getPersonnel_id() {
        return personnel_id;
    }

    public void setPersonnel_id(Long personnel_id) {
        this.personnel_id = personnel_id;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "auto_pk_id=" + auto_pk_id +
                ", num='" + num + '\'' +
                ", color='" + color + '\'' +
                ", mark='" + mark + '\'' +
                ", personnel_id=" + personnel_id +
                ", auto_personnel=" + auto_personnel +
                '}';
    }

    public Auto_personnel getAuto_personnel() {
        return auto_personnel;
    }

    public void setAuto_personnel(Auto_personnel auto_personnel) {
        this.auto_personnel = auto_personnel;
        this.personnel_id = auto_personnel.getAuto_personnel_pk_id();
    }
}
