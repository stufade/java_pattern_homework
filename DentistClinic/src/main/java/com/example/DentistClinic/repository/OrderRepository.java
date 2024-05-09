package com.example.DentistClinic.repository;

import com.example.DentistClinic.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
