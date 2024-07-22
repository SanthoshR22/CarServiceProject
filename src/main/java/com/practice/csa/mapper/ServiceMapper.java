package com.practice.csa.mapper;

import org.apache.naming.ServiceRef;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.practice.csa.entity.Services;
import com.practice.csa.requestdto.ServiceRequest;
import com.practice.csa.responesdto.ServiceResponesDTO;

@Component
public class ServiceMapper {
	
	public static Services mapToService(ServiceRequest request ) {
		Services service = new Services();
		service.setServiceType(request.getServiceType());
		service.setServiceCost(request.getServiceCost());
		service.setServiceDescription(request.getServiceDescription());
		return service;
	}
	
	public static ServiceResponesDTO mapToServiceResponesDTO(Services response) {
		ServiceResponesDTO dto = new ServiceResponesDTO();
		dto.setServiceId(response.getServiceId());
		dto.setServiceType(response.getServiceType());
		dto.setServiceCost(response.getServiceCost());
		dto.setServiceDescription(response.getServiceDescription());
		return dto;
	}

}
