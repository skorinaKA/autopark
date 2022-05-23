package com.example.autopark.service;

import com.example.autopark.entity.Routes;

public interface Routes_Service {
    Iterable<Routes> listRoutes();
    Routes getRoutes(Long routes_pk_id);
    Routes setRoutes(Routes routes);
    Routes putRoutes(Long id, Routes routes);
    void deleteRoutes(Long routes_pk_id);
}
