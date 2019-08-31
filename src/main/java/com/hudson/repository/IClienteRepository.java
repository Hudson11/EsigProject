package com.hudson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hudson.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long>{

}
