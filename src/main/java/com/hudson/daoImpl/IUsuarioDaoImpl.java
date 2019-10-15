package com.hudson.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudson.Dao.IUsuarioDao;
import com.hudson.model.Usuario;
import com.hudson.repository.IUsuarioRepository;

@Service
public class IUsuarioDaoImpl implements IUsuarioDao{
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public void save(Usuario object) {
		// TODO Auto-generated method stub
		this.usuarioRepository.save(object);
	}

	@Override
	public void delete(Usuario object) {
		// TODO Auto-generated method stub
		this.usuarioRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.usuarioRepository.findById(id);
	}

	@Override
	public void deleteAll(List<Usuario> list) {
		// TODO Auto-generated method stub
		this.usuarioRepository.deleteAll(list);
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findByCpf(Long cpf) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findByCpf(cpf);
	}

}
