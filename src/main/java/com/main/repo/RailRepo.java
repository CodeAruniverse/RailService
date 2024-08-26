package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Rail;

@Repository
public interface RailRepo extends JpaRepository<Rail, String>{
}
