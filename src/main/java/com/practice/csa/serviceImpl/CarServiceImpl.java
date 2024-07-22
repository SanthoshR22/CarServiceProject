package com.practice.csa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.practice.csa.entity.Car;
import com.practice.csa.exception.CarNotFoundByIdException;
import com.practice.csa.mapper.CarMapper;
import com.practice.csa.mapper.ServiceMapper;
import com.practice.csa.repositary.CarRepositary;
import com.practice.csa.requestdto.CarRequestDto;
import com.practice.csa.responesdto.CarResponesDto;
import com.practice.csa.responesdto.ServiceResponesDTO;
import com.practice.csa.service.CarService;
import com.practice.csa.utility.ResponesStructure;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepositary carRepositary;

//	@Autowired
//	private CarMapper carMapper;

	@Override
	public ResponseEntity<ResponesStructure<CarResponesDto>> addCar(CarRequestDto car) {
		Car car2 = carRepositary.save(CarMapper.mapToCar(car));
		CarResponesDto carResponesDto = CarMapper.mapToCarResponse(car2);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponesStructure<CarResponesDto>().setStatusCode(HttpStatus.CREATED.value())
						.setMessage("Data Created SuccesFully").setData(carResponesDto));

	}
	// ---------------------------------------------------------------------------------------------------------------------------------

	@Override
	public ResponseEntity<ResponesStructure<CarResponesDto>> updateCarById(int carId, CarRequestDto update) {
		return carRepositary.findById(carId).map(carupdate -> {
			Car car = CarMapper.mapToCar(update);
			car.setCarId(carupdate.getCarId());

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponesStructure<CarResponesDto>().setStatusCode(HttpStatus.OK.value())
							.setMessage("Data Updated SuccesFully..")
							.setData(CarMapper.mapToCarResponse(carRepositary.save(car))));
		}).orElseThrow(() -> new CarNotFoundByIdException("Failed to find CarId.."));

	}
	// ---------------------------------------------------------------------------------------------------------------------------------

	@Override
	public ResponseEntity<ResponesStructure<CarResponesDto>> findCarById(int carId) {
		return carRepositary.findById(carId)
				.map(car -> ResponseEntity.status(HttpStatus.FOUND)
						.body(new ResponesStructure<CarResponesDto>().setStatusCode(HttpStatus.FOUND.value())
								.setMessage("Data Founded SuccessFully..").setData(CarMapper.mapToCarResponse(car))))
				.orElseThrow(() -> new CarNotFoundByIdException("Failed to found CarId..."));
	}	
	// ---------------------------------------------------------------------------------------------------------------------------------

	@Override
	public ResponseEntity<ResponesStructure<CarResponesDto>> deleteCarById(int carId) {
		return carRepositary.findById(carId).map(car -> {
			carRepositary.deleteById(carId);

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponesStructure<CarResponesDto>().setStatusCode(HttpStatus.OK.value())
							.setMessage("Data Deleted SuccessFully...").setData(CarMapper.mapToCarResponse(car)));
		}).orElseThrow(() -> new CarNotFoundByIdException("Failed to find CarId.."));
	}
	// ---------------------------------------------------------------------------------------------------------------------------------

	@Override
	public ResponseEntity<ResponesStructure<List<CarResponesDto>>> findAllCars() {
		List<CarResponesDto> cars = carRepositary.findAll().stream().map(car -> CarMapper.mapToCarResponse(car))
				.toList();
		ResponesStructure<List<CarResponesDto>> responesStructure = new ResponesStructure<List<CarResponesDto>>();
		responesStructure.setStatusCode(HttpStatus.FOUND.value());
		responesStructure.setMessage("Datas find Successfully...");
		responesStructure.setData(cars);

		return new ResponseEntity<ResponesStructure<List<CarResponesDto>>>(responesStructure, HttpStatus.FOUND);

	}
}
