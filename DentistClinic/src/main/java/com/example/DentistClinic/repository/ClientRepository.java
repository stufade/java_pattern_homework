package com.example.DentistClinic.repository;

import com.example.DentistClinic.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

