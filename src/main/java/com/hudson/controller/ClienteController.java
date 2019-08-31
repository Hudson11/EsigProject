package com.hudson.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hudson.Dao.IUsuarioDaoImpl;
import com.hudson.Dao.iClienteDaoImpl;
import com.hudson.model.Cliente;
import com.hudson.model.Usuario;

@Scope(value = "session")
@Component(value = "clienteController")
@ELBeanName(value = "clienteController")
@Join(path = "/growl", to="/growl.jsf")
public class ClienteController {
	
	private Cliente cliente;
	private Usuario usuario;
	
	private List<Cliente> listCliente;
	
	private String repeteSenha;
	
	@Autowired
	private IUsuarioDaoImpl userDao;
	@Autowired
	private iClienteDaoImpl clienteDao;
	
	ClienteController(){
		this.cliente 		= new Cliente();
		this.usuario 		= new Usuario();
		this.listCliente 	= new ArrayList<Cliente>();
	}
	
	// Cadastro de Cliente
	public String cadastraCliente() {
		
		usuario.setCliente(cliente);
		clienteDao.save(cliente);
		
		userDao.save(usuario);
		
		usuario = new Usuario();
		cliente = new Cliente();
		
		return "/cliente-form?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
	}

	public String getRepeteSenha() {
		return repeteSenha;
	}

	public void setRepeteSenha(String repeteSenha) {
		this.repeteSenha = repeteSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public IUsuarioDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(IUsuarioDaoImpl userDao) {
		this.userDao = userDao;
	}

	public iClienteDaoImpl getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(iClienteDaoImpl clienteDao) {
		this.clienteDao = clienteDao;
	}
	
}
