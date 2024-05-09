package com.example.DentistClinic.service;

import java.util.List;

import com.example.DentistClinic.model.BusinessService;
import com.example.DentistClinic.repository.BusinessServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceService {

    @Autowired
    private BusinessServiceRepository serviceRepository;

    public List<BusinessService> findAllServices() {
        return serviceRepository.findAll();
    }

    public BusinessService findServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public BusinessService saveService(BusinessService service) {
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
