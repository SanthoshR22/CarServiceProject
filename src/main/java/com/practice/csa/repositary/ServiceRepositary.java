package com.practice.csa.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.practice.csa.entity.Services;

@Repository
public interface ServiceRepositary extends JpaRepository<Services, Integer>{

}
