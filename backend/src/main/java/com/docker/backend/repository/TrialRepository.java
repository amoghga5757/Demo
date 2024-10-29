package com.docker.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.backend.model.TrialTable;

public interface TrialRepository extends JpaRepository<TrialTable, Integer>{
    
}
