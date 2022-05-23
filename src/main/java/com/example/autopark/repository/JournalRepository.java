package com.example.autopark.repository;

import com.example.autopark.entity.Journal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface JournalRepository extends PagingAndSortingRepository<Journal, Long> {
}
