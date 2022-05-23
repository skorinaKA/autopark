package com.example.autopark.repository;

import com.example.autopark.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends PagingAndSortingRepository<Users,Long> {
    @Query(value = "SELECT * FROM Users t WHERE t.login=:login",nativeQuery = true)
    Optional<Users> findByLogin(@Param("login") String login);
}
