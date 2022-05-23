package com.example.autopark.service;

import com.example.autopark.entity.Routes;
import com.example.autopark.exception.RoutesNotFoundException;
import com.example.autopark.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Routes_ServiceImpl implements Routes_Service{

    @Autowired
    private RoutesRepository routesRepository;

    @Override
    public Iterable<Routes> listRoutes() {
        return routesRepository.findAll();
    }

    @Override
    public Routes getRoutes(Long routes_pk_id) {
        Optional<Routes> optionalRoutes = routesRepository.findById(routes_pk_id);
        if(optionalRoutes.isPresent()){
            return optionalRoutes.get();
        }else {
            throw new RoutesNotFoundException("Routes not found!");
        }
    }

    @Override
    public Routes setRoutes(Routes routes) {
        return routesRepository.save(routes);
    }

    @Override
    public Routes putRoutes(Long id, Routes routes) {
        routes.setRoutes_pk_id(id);
        return routesRepository.save(routes);
    }

    @Override
    public void deleteRoutes(Long routes_pk_id) {
        routesRepository.deleteById(routes_pk_id);
    }
}
