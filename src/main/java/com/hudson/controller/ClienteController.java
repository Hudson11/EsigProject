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

import com.hudson.Dao.IitemDao;
import com.hudson.Dao.IitemDaoImpl;
import com.hudson.model.Item;

@Scope(value = "session")
@Component(value = "itemController")
@ELBeanName(value = "itemController")
@Join(path = "/", to="/cliente-form.jsf")
public class ClienteController implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2258161782656916704L;

	@Autowired
	IitemDaoImpl itemDao;
	private Item item;
	private List<Item> listItem;
	private Integer qtdItemAtivos;
	private Integer qtdItemAprovados;
	
	public ClienteController() {
		
		this.item = new Item();
		this.listItem = new ArrayList<>();
		
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
		listItem = this.itemDao.findAll();
	}
	
	// OK
	public String save() {
		
		if (item.getName() == null || item.getName().trim() == "") {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unsuccefull", "Message: unsuccessful: field is empty"));
			return null;
		}
		
		item.setStatus(false);
		
		try {
			itemDao.save(item);
			item = new Item();
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
		
		itemDao.deleteById(id);
		loadData();
		
		return "/cliente-form.xhtml?faces-redirect=true";
	}
	
	// OK
	public void mudarStatus(Item t) {
		if (t.getStatus()) {
			t.setStatus(false);
		} else {
			t.setStatus(true);
		}
		this.itemDao.save(t);
	}
	
	// OK
	public List<Item> listCompleted() {
		
		loadData();
		
		this.listItem = itemDao.findByItemStatusAprovado();
		
		return this.listItem;
	}
	
	// OK
	public List<Item> listActives() {
		
		loadData();
		
		this.listItem = itemDao.findByItemStatus();
		
		return this.listItem;
	}
	
	// OK
	public void deleteCompleted() {
		
		List<Item> actives = new ArrayList<>();
		
		actives = this.listCompleted();
		
		this.itemDao.deleteAll(actives);
		
		loadData();
	}
	
	// OK
	public void setStatusTrueAll() {
		
		loadData();
		
		for(Item c: this.getListItem()) {
			if (c.getStatus() == false)
				c.setStatus(true);
			this.itemDao.save(c);
		}
	}
	
	// Tested
	public String updateItem(Item object) {
		this.item = object;
		return "/cliente-form.xhtml?faces-redirect=true";
	}
	
	/*
	 *  GETTERS AND SETTERS
	 * */
	public Item getItem() {
		return item;
	}

	public List<Item> getListItem() {
		return listItem;
	}

	public IitemDaoImpl getItemDao() {
		return itemDao;
	}

	public Integer getQtdItemAtivos() {
		return qtdItemAtivos = itemDao.findByItemStatus().size();
	}

	public Integer getQtdItemAprovados() {
		return qtdItemAprovados = itemDao.findByItemStatusAprovado().size();
	}

	
}
