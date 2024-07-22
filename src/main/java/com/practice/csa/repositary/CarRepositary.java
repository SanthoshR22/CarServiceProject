package com.practice.csa.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.csa.entity.Car;

@Repository
public interface CarRepositary extends JpaRepository<Car, Integer> {

}
