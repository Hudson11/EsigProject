package com.hudson.Dao;

import com.hudson.model.Cliente;

public interface IClienteDao extends IGenericDao<Cliente, Integer>{
	
	Cliente findClienteByCpf(Long cpf);
	
	Cliente findClienteByRg(Long rg);
	
	Cliente removeClienteByCpf(Long cpf);
	
}
