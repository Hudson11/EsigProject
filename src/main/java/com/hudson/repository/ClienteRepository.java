package com.hudson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.hudson.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query(value = "SELECT FROM * cliente c WHERE c.status = false", nativeQuery = true)
	List <Cliente> findByClienteStatus();
	
	@Query(value = "SELECT FROM * cliente c WHERE c.status = true", nativeQuery = true)
	List <Cliente> findByClienteStatusAprovado();
	
}
