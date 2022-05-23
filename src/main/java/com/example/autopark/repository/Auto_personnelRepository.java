package com.example.autopark.repository;

import com.example.autopark.entity.Auto_personnel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface Auto_personnelRepository extends PagingAndSortingRepository<Auto_personnel, Long> {
}
