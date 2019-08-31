package com.hudson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hudson.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query(value = "SELECT * FROM cliente c where c.cpf = {cpf}", nativeQuery = true)
	Cliente findClienteByCpf(Long cpf);
	
	@Query(value = "SELECT * FROM cliente c WHERE c.rg = {rg}", nativeQuery = true)
	Cliente findClienteByRg(Long rg);
	
	@Query(value = "DELETE cliente c WHERE c.cpf = {cpf}", nativeQuery = true)
	Cliente removeClienteByCpf(Long cpf);

}
