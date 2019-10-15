package com.hudson.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hudson.generics.IGenericDao;
import com.hudson.model.Item;

public interface IitemDao extends IGenericDao<Item, Integer>{
	
	List<Item> findByItemStatus();
	
	List<Item> findByItemStatusAprovado();

}
