package com.practice.csa.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.csa.entity.Services;
import com.practice.csa.exception.ServiceNotFoundByIdException;
import com.practice.csa.mapper.CarMapper;
import com.practice.csa.mapper.ServiceMapper;
import com.practice.csa.repositary.CarRepositary;
import com.practice.csa.repositary.ServiceRepositary;
import com.practice.csa.requestdto.ServiceRequest;
import com.practice.csa.responesdto.CarResponesDto;
import com.practice.csa.responesdto.ServiceResponesDTO;
import com.practice.csa.service.ServiceService;
import com.practice.csa.utility.ResponesStructure;

import aj.org.objectweb.asm.commons.SerialVersionUIDAdder;

@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepositary serviceRepositary;

	@Override
	public ResponseEntity<ResponesStructure<ServiceResponesDTO>> addService(ServiceRequest service) {

		Services services = serviceRepositary.save(ServiceMapper.mapToService(service));
		ServiceResponesDTO dto = ServiceMapper.mapToServiceResponesDTO(services);

		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponesStructure<ServiceResponesDTO>()
				.setStatusCode(HttpStatus.CREATED.value()).setMessage("Data created SuccessFully...").setData(dto));

	}

	@Override
	public ResponseEntity<ResponesStructure<ServiceResponesDTO>> updateService(int serviceId, ServiceRequest update) {
		return serviceRepositary.findById(serviceId).map(service -> {
			Services services = ServiceMapper.mapToService(update);
			service.setServiceCost(service.getServiceCost());

			return ResponseEntity.status(HttpStatus.FOUND)
					.body(new ResponesStructure<ServiceResponesDTO>().setStatusCode(HttpStatus.FOUND.value())
							.setMessage("Data updated SuccessFully...")
							.setData(ServiceMapper.mapToServiceResponesDTO(service)));

		}).orElseThrow(() -> new ServiceNotFoundByIdException("Failed to find ServiceId..."));

	}

	@Override
	public ResponseEntity<ResponesStructure<ServiceResponesDTO>> findServiceById(int serviceId) {
		return serviceRepositary.findById(serviceId)
				.map(service -> ResponseEntity.status(HttpStatus.FOUND)
						.body(new ResponesStructure<ServiceResponesDTO>().setStatusCode(HttpStatus.FOUND.value())
								.setMessage("Data founded SuccessFully...")
								.setData(ServiceMapper.mapToServiceResponesDTO(service))))
				.orElseThrow(() -> new ServiceNotFoundByIdException("Failed to find ServiceId..."));

	}

	@Override
	public ResponseEntity<ResponesStructure<ServiceResponesDTO>> deleteServiceById(int serviceId) {
		return serviceRepositary.findById(serviceId).map(service -> {
			serviceRepositary.deleteById(serviceId);

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponesStructure<ServiceResponesDTO>().setStatusCode(HttpStatus.OK.value())
							.setMessage("Data Deleted Succesfully...")
							.setData(ServiceMapper.mapToServiceResponesDTO(service)));
		}).orElseThrow(() -> new ServiceNotFoundByIdException("Failed to find ServiceId..."));

	}

	@Override
	public ResponseEntity<ResponesStructure<List<ServiceResponesDTO>>> findAllService() {
		List<ServiceResponesDTO> dtos = serviceRepositary.findAll().stream()
				.map(sev -> ServiceMapper.mapToServiceResponesDTO(sev)).toList();
		ResponesStructure<List<ServiceResponesDTO>> responesStructure = new ResponesStructure<List<ServiceResponesDTO>>();
		responesStructure.setStatusCode(HttpStatus.OK.value());
		responesStructure.setMessage("Data finded SuccesFully...");
		responesStructure.setData(dtos);
		return new ResponseEntity<ResponesStructure<List<ServiceResponesDTO>>>(responesStructure, HttpStatus.OK);
	}

}
