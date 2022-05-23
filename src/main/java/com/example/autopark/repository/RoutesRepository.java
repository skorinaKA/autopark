package com.example.autopark.repository;

import com.example.autopark.entity.Routes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface RoutesRepository extends PagingAndSortingRepository<Routes, Long> {
}