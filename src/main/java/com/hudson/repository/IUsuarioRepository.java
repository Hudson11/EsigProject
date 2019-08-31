package com.hudson.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hudson.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value = "SELECT * FROM cliente c where c.cpf = {cpf}", nativeQuery = true)
	Optional<Usuario> findByCpf(Long cpf);
	
}
