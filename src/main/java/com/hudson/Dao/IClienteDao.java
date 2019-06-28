package com.hudson.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hudson.model.Cliente;

public interface IClienteDao extends IGenericDao<Cliente, Integer>{
	
	List<Cliente> findByClienteStatus();
	
	List<Cliente> findByClienteStatusAprovado();

}
