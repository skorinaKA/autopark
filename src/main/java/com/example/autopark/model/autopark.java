package com.example.autopark.model;

import com.example.autopark.entity.Auto;
import com.example.autopark.entity.Auto_personnel;
import com.example.autopark.entity.Journal;
import com.example.autopark.entity.Routes;

public class autopark {
    private Auto auto;
    private Auto_personnel auto_personnel;
    private Journal journal;
    private Routes routes;

    public autopark(Auto auto, Auto_personnel auto_personnel, Journal journal, Routes routes) {
        this.auto = auto;
        this.auto_personnel = auto_personnel;
        this.journal = journal;
        this.routes = routes;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Auto_personnel getAuto_personnel() {
        return auto_personnel;
    }

    public void setAuto_personnel(Auto_personnel auto_personnel) {
        this.auto_personnel = auto_personnel;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }
}
