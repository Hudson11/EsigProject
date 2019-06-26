package com.hudson.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudson.model.Cliente;
import com.hudson.repository.ClienteRepository;

@Service
public  class IClienteDaoImpl implements IClienteDao{
	
	@Autowired(required = true)
	private ClienteRepository clienteRepository;

	@Override
	public void save(Cliente object) {
		// TODO Auto-generated method stub
		this.clienteRepository.save(object);
	}

	@Override
	public void delete(Cliente object) {
		// TODO Auto-generated method stub
		this.clienteRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.clienteRepository.deleteById(id);
	}

	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return this.findById(id);
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return this.clienteRepository.findAll();
	}

	@Override
	public List<Cliente> findByClienteStatus() {
		// TODO Auto-generated method stub
		return this.clienteRepository.findByClienteStatus();
	}

	@Override
	public List<Cliente> findByClienteStatusAprovado() {
		// TODO Auto-generated method stub
		return this.clienteRepository.findByClienteStatusAprovado();
	}
	
}
