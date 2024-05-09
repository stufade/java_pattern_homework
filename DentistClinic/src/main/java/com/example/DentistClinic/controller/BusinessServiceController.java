package com.example.DentistClinic.controller;

import java.util.List;
import com.example.DentistClinic.model.BusinessService;
import com.example.DentistClinic.service.BusinessServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
public class BusinessServiceController {

    @Autowired
    private BusinessServiceService businessServiceService;

    @GetMapping
    public List<BusinessService> getAllServices() {
        return businessServiceService.findAllServices();
    }

    @GetMapping("/{id}")
    public BusinessService getServiceById(@PathVariable Long id) {
        return businessServiceService.findServiceById(id);
    }

    @PostMapping
    public BusinessService createService(@RequestBody BusinessService service) {
        return businessServiceService.saveService(service);
    }

    @PutMapping("/{id}")
    public BusinessService updateService(@PathVariable Long id, @RequestBody BusinessService serviceDetails) {
        BusinessService service = businessServiceService.findServiceById(id);
        service.setServiceName(serviceDetails.getServiceName());
        service.setPrice(serviceDetails.getPrice());
        return businessServiceService.saveService(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        businessServiceService.deleteService(id);
    }
}
