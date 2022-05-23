package com.example.autopark.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "routes_pk_id")
    private Long routes_pk_id;

    private String name;

    public Routes(){

    }

    public Routes(String name) {
        //this.routes_pk_id = routes_pk_id;
        this.name = name;
    }

    public Long getRoutes_pk_id() {
        return routes_pk_id;
    }

    public void setRoutes_pk_id(Long routes_pk_id) {
        this.routes_pk_id = routes_pk_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Routes\n{" +
                "routes_pk_id=" + routes_pk_id +
                ", name='" + name + '\'' +
                '}';
    }
}
