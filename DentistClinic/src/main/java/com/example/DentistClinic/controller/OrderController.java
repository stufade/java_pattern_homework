package com.example.DentistClinic.controller;

import java.util.List;

import com.example.DentistClinic.model.BusinessService;
import com.example.DentistClinic.model.Client;
import com.example.DentistClinic.model.Employee;
import com.example.DentistClinic.model.Order;
import com.example.DentistClinic.service.BusinessServiceService;
import com.example.DentistClinic.service.ClientService;
import com.example.DentistClinic.service.EmployeeService;
import com.example.DentistClinic.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

class CreateOrderRequest {
    private Long employeeId;
    private Long clientId;
    private Long serviceId;
    private Date orderDate;

    // Сеттеры
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    // Геттеры
    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private  ClientService clientService;

    @Autowired
    BusinessServiceService businessServiceService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest request) {
        System.out.println(request.getClientId());
        Employee employee = employeeService.findEmployeeById(request.getEmployeeId());
        Client client = clientService.findClientById(request.getClientId());
        BusinessService service = businessServiceService.findServiceById(request.getServiceId());

        if (employee == null || client == null || service == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid employee, client, or service ID");
        }

        Order order = new Order();
        order.setEmployee(employee);
        order.setClient(client);
        order.setService(service);
        order.setOrderDate(request.getOrderDate());

        return orderService.saveOrder(order);
    }


    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id,
                             @RequestBody Order orderDetails) {
        Order order = orderService.findOrderById(id);
        order.setEmployee(orderDetails.getEmployee());
        order.setClient(orderDetails.getClient());
        order.setService(orderDetails.getService());
        order.setOrderDate(orderDetails.getOrderDate());
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
