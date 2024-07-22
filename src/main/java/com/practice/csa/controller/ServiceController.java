package com.practice.csa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.csa.entity.Services;
import com.practice.csa.requestdto.ServiceRequest;
import com.practice.csa.responesdto.ServiceResponesDTO;
import com.practice.csa.service.ServiceService;
import com.practice.csa.utility.ResponesStructure;

@Controller
public class ServiceController {
	
	@Autowired
	private ServiceService serviceService;
	
	@PostMapping("/services")
	public ResponseEntity<ResponesStructure<ServiceResponesDTO>> addServie (@RequestBody ServiceRequest service){
		return serviceService.addService(service);
	}
	
	@PutMapping("/services/{serviceId}")
	public ResponseEntity<ResponesStructure<ServiceResponesDTO>> updateService(@PathVariable int serviceId,@RequestBody ServiceRequest update){
		return serviceService.updateService(serviceId,update);
	}
	

	@GetMapping("/services/{serviceId}")
	public ResponseEntity<ResponesStructure<ServiceResponesDTO>> findServiceById(@PathVariable int serviceId){
		return serviceService.findServiceById(serviceId);
	}
	
	@DeleteMapping("/services/{serviceId}")
	public ResponseEntity<ResponesStructure<ServiceResponesDTO>> deleteServiceById(@PathVariable int serviceId){
		return serviceService.deleteServiceById(serviceId);
	}
	
	@GetMapping("/services")
	public ResponseEntity<ResponesStructure<List<ServiceResponesDTO>>> findAllService(){
		return serviceService.findAllService();
	}


}








