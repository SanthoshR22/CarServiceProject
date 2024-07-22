package com.practice.csa.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.csa.entity.Car;
import com.practice.csa.requestdto.CarRequestDto;
import com.practice.csa.responesdto.CarResponesDto;
import com.practice.csa.utility.ResponesStructure;

@Service
public interface CarService {

	ResponseEntity<ResponesStructure<CarResponesDto>> addCar(CarRequestDto car);

	ResponseEntity<ResponesStructure<CarResponesDto>> updateCarById(int carId, CarRequestDto update);

	ResponseEntity<ResponesStructure<CarResponesDto>> findCarById(int carId);

	ResponseEntity<ResponesStructure<CarResponesDto>> deleteCarById(int carId);
	
	ResponseEntity<ResponesStructure<List<CarResponesDto>>> findAllCars();

}
