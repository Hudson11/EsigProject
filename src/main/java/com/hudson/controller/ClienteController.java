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
import com.hudson.Dao.IClienteDaoImpl;
import com.hudson.model.Cliente;

@Scope(value = "session")
@Component(value = "clienteController")
@ELBeanName(value = "clienteController")
@Join(path = "/", to="/cliente-form.jsf")
public class ClienteController implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2258161782656916704L;

	@Autowired
	IClienteDaoImpl clienteDao;
	private Cliente cliente;
	private List<Cliente> listCliente;
	private Integer qtdClienteAtivos;
	private Integer qtdClienteAprovados;
	
	public ClienteController() {
		
		this.cliente = new Cliente();
		this.listCliente = new ArrayList<>();
		
		//this.getQtdClienteAtivos();
		
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
	
	// OK
	public String save() {
		
		if (cliente.getName() == null || cliente.getName().trim() == "") {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unsuccefull", "Message: unsuccessful: field is empty"));
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
	
	// OK
	public String remove(Long id) {
		
		clienteDao.deleteById(id);
		loadData();
		
		return "/cliente-form.xhtml?faces-redirect=true";
	}
	
	// OK
	public void mudarStatus(Cliente t) {
		if (t.getStatus()) {
			t.setStatus(false);
		} else {
			t.setStatus(true);
		}
		this.clienteDao.save(t);
	}
	
	// OK
	public List<Cliente> listCompleted() {
		
		List<Cliente> listCliCompleted = new ArrayList<>();
		
		loadData();
		
		for(Cliente c: this.getListCliente()) {
			if (c.getStatus() == true) 
				listCliCompleted.add(c);
		}
		
		this.listCliente = listCliCompleted;
		
		return listCliCompleted;
	}
	
	// OK
	public List<Cliente> listActives() {
		
		List<Cliente> listCliCompleted = new ArrayList<>();
		
		loadData();
		
		for(Cliente c: this.getListCliente()) {
			if (c.getStatus() == false) 
				listCliCompleted.add(c);
		}
		
		this.listCliente = listCliCompleted;
		
		return listCliCompleted;
	}
	
	// OK
	public void deleteCompleted() {
		
		List<Cliente> actives = new ArrayList<>();
		
		actives = this.listCompleted();
		
		this.clienteDao.deleteAll(actives);
		
		loadData();
	}
	
	// Tested
	public void setStatusTrueAll() {
		
		loadData();
		
		for(Cliente c: this.getListCliente()) {
			if (c.getStatus() == false)
				c.setStatus(true);
			this.clienteDao.save(c);
		}
	}
	
	/*
	 *  GETTERS AND SETTERS
	 * */
	public Cliente getCliente() {
		return cliente;
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public IClienteDaoImpl getClienteDao() {
		return clienteDao;
	}

	public Integer getQtdClienteAtivos() {
		return qtdClienteAtivos = clienteDao.findByClienteStatus().size();
	}

	public Integer getQtdClienteAprovados() {
		return qtdClienteAprovados = clienteDao.findByClienteStatusAprovado().size();
	}

	
}
