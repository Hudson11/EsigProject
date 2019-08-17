package com.hudson.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudson.model.Cliente;
import com.hudson.repository.IClienteRepository;

@Service
public class IClienteImpl implements IClienteDao{
	
	@Autowired
	private IClienteRepository clienteRepository;

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
	public void deleteAll(List<Cliente> list) {
		// TODO Auto-generated method stub
		this.clienteRepository.deleteAll(list);
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente findClienteByCpf(Long cpf) {
		// TODO Auto-generated method stub
		return this.clienteRepository.findClienteByCpf(cpf);
	}

	@Override
	public Cliente findClienteByRg(Long rg) {
		// TODO Auto-generated method stub
		return this.clienteRepository.findClienteByRg(rg);
	}

	@Override
	public Cliente removeClienteByCpf(Long cpf) {
		// TODO Auto-generated method stub
		return this.clienteRepository.removeClienteByCpf(cpf);
	}

}
