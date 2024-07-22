package com.practice.csa.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.practice.csa.entity.Services;
import com.practice.csa.requestdto.ServiceRequest;
import com.practice.csa.responesdto.ServiceResponesDTO;
import com.practice.csa.utility.ResponesStructure;

public interface ServiceService  {

	ResponseEntity<ResponesStructure<ServiceResponesDTO>> addService(ServiceRequest service);

	ResponseEntity<ResponesStructure<ServiceResponesDTO>> updateService(int serviceId, ServiceRequest update);

	ResponseEntity<ResponesStructure<ServiceResponesDTO>> findServiceById(int serviceId);

	ResponseEntity<ResponesStructure<ServiceResponesDTO>> deleteServiceById(int serviceId);

	ResponseEntity<ResponesStructure<List<ServiceResponesDTO>>> findAllService();

}





