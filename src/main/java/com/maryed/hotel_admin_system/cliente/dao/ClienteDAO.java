package com.maryed.hotel_admin_system.cliente.dao;

import com.maryed.hotel_admin_system.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByDni(String dni);
}
