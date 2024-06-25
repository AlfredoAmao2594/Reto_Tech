package com.reto.tech.springboot.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.tech.springboot.app.Model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
