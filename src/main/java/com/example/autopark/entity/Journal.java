package com.example.autopark.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "journal_pk_id")
    private Long journal_pk_id;

    private Timestamp time_out;

    private Timestamp time_in;


    private Long auto_id;

    private Long route_id;

    public Long getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(Long auto_id) {
        this.auto_id = auto_id;
    }

    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }

    @ManyToOne/*(optional = false,cascade = CascadeType.MERGE)*/
    @JoinColumn(name = "auto_id",insertable = false,updatable = false)
    private Auto auto;

    @ManyToOne/*(optional = false,cascade = CascadeType.MERGE)*/
    @JoinColumn(name = "route_id",insertable = false,updatable = false)
    private Routes routes;

    public Journal(Timestamp time_out, Timestamp time_in, Auto auto, Routes routes) {
        //this.journal_pk_id = journal_pk_id;
        this.time_out = time_out;
        this.time_in = time_in;
        this.auto = auto;
        this.routes = routes;
        this.auto_id = auto.getAuto_pk_id();
        this.route_id = routes.getRoutes_pk_id();
    }

    public Journal() {

    }

    public Long getJournal_pk_id() {
        return journal_pk_id;
    }

    public void setJournal_pk_id(Long journal_pk_id) {
        this.journal_pk_id = journal_pk_id;
    }

    public Timestamp getTime_out() {
        return time_out;
    }

    public void setTime_out(Timestamp time_out) {
        this.time_out = time_out;
    }

    public Timestamp getTime_in() {
        return time_in;
    }

    public void setTime_in(Timestamp time_in) {
        this.time_in = time_in;
    }

/*
    public Long getAuto_id() {
        return auto_id;
    }
*/

    /*public void setAuto_id(Long auto_id) {
        this.auto_id = auto_id;
    }*/

    /*public Long getRoute_id() {
        return route_id;
    }*/

    /*public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }*/

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
        this.auto_id = auto.getAuto_pk_id();
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
        this.route_id = routes.getRoutes_pk_id();
    }

    @Override
    public String toString() {
        return "Journal{" +
                "journal_pk_id=" + journal_pk_id +
                ", time_out=" + time_out +
                ", time_in=" + time_in +
                ", auto_id=" + auto_id +
                ", route_id=" + route_id +
                ", auto=" + auto +
                ", routes=" + routes +
                '}';
    }
}
