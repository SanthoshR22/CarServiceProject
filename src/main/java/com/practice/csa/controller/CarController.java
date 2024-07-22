package com.practice.csa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.csa.entity.Car;
import com.practice.csa.requestdto.CarRequestDto;
import com.practice.csa.responesdto.CarResponesDto;
import com.practice.csa.service.CarService;
import com.practice.csa.utility.ResponesStructure;

@Controller
//@RequestMapping("car/v1")
public class CarController {
	
	@Autowired
	private CarService carService; 
	
	
	@PostMapping("/cars")
	public ResponseEntity<ResponesStructure<CarResponesDto>> addCar(@RequestBody CarRequestDto car){
		return carService.addCar(car);
	}
	
	@PutMapping("/cars/{carId}")
	public ResponseEntity<ResponesStructure<CarResponesDto>> updateCarById (@RequestParam int carId ,@RequestBody CarRequestDto update){
		return carService.updateCarById( carId,  update);
	}
	
	@GetMapping("/cars/{carId}")
	public ResponseEntity<ResponesStructure<CarResponesDto>> findCarById(@RequestParam int carId){
		return carService.findCarById(carId);
	}
	
	@DeleteMapping("/cars/{carId}")
	public ResponseEntity<ResponesStructure<CarResponesDto>> deleteCarById(@RequestParam int carId){
		return carService.deleteCarById(carId);
	}
	
	@GetMapping("/cars")
	public ResponseEntity<ResponesStructure<List<CarResponesDto>>> findAllCar(){
		return carService.findAllCars();
	}


}
