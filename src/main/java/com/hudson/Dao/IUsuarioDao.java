package com.hudson.Dao;

import java.util.Optional;

import com.hudson.generics.IGenericDao;
import com.hudson.model.Usuario;

public interface IUsuarioDao extends IGenericDao<Usuario, Integer>{
	
	Optional<Usuario> findByCpf(Long cpf); 

}
