package com.hudson.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudson.Dao.IClienteDao;
import com.hudson.model.Cliente;
import com.hudson.repository.IClienteRepository;

@Service
public class iClienteDaoImpl implements IClienteDao{

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
		this.clienteRepository.deleteById(id);;
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

}
