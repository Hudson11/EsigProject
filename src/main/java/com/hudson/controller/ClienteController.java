package com.hudson.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hudson.Dao.IClienteDao;
import com.hudson.model.Cliente;

@Scope(value = "session")
@Component(value = "clienteController")
@ELBeanName(value = "clienteController")
@Join(path = "/", to="/cliente-form.jsf")
public class ClienteController implements Serializable{
	
	@Autowired
	IClienteDao clienteDao;
	
	private Cliente cliente;
	
	private List<Cliente> listCliente;
	
	private Integer qtdClienteAtivos;
	
	private Integer qtdClienteAprovados;
	
	public ClienteController() {
		
		this.cliente = new Cliente();
		this.listCliente = new ArrayList<>();
		
	}
	
	/**
	 * Estas anotações são necessárias para carregar a coleção de dados antes da
	 * renderização da view.
	 */
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		listCliente = this.clienteDao.findAll();
	}
	
	public String save() {
		
		if (cliente.getName() == null || cliente.getName().trim() == "") {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Vazio", null));
			return null;
		}
		
		cliente.setStatus(false);
		
		try {
			clienteDao.save(cliente);
			cliente = new Cliente();
			loadData();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Erro de Persistência", null));
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Cliente Cadastrado", null));
		
		return "/cliente-form.xhtml?faces-redirect=true";
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
	
	
}
