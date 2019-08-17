package com.hudson.controller;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hudson.Dao.IClienteImpl;
import com.hudson.model.Cliente;

@Scope(value = "session")
@Component(value = "clienteController")
@ELBeanName(value = "clienteController")
@Join(path = "/cadastrocliente", to="/form.jsf")
public class ClienteController {
	
	private Cliente cliente;
	
	private List<Cliente> listCliente;
	
	@Autowired
	private IClienteImpl dao;
	
	ClienteController(){
		this.cliente = new Cliente();
		this.listCliente = new ArrayList<Cliente>();
	}
	
	public String cadastraCliente() {
		this.dao.save(cliente);
		this.cliente = new Cliente();
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

	public IClienteImpl getDao() {
		return dao;
	}

	public void setDao(IClienteImpl dao) {
		this.dao = dao;
	}
	
	

}
