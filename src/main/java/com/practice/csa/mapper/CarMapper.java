package com.practice.csa.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.csa.entity.Car;
import com.practice.csa.requestdto.CarRequestDto;
import com.practice.csa.responesdto.CarResponesDto;
import com.practice.csa.service.CarService;

import jakarta.persistence.MappedSuperclass;

@Component
public class CarMapper {
	
	public static Car mapToCar(CarRequestDto request) {
		Car car = new Car();
		car.setCarBrand(request.getCarBrand());
		car.setCarModel(request.getCarModel());
		return car;
	}
	
	public static CarResponesDto mapToCarResponse(Car car) {
		CarResponesDto carResponesDto = new CarResponesDto();
		carResponesDto.setCarId(car.getCarId());
		carResponesDto.setCarBrand(car.getCarBrand());
		carResponesDto.setCarModel(car.getCarModel());
		return carResponesDto;
	}

}
