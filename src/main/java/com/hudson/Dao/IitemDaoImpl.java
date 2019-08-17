package com.hudson.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudson.model.Item;
import com.hudson.repository.ItemRepository;
import com.sun.mail.imap.protocol.ID;

@Service
public  class IitemDaoImpl implements IitemDao{
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void save(Item object) {
		// TODO Auto-generated method stub
		this.itemRepository.save(object);
	}

	@Override
	public void delete(Item object) {
		// TODO Auto-generated method stub
		this.itemRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.itemRepository.deleteById(id);
	}

	@Override
	public Optional<Item> findById(Long id) {
		// TODO Auto-generated method stub
		return this.itemRepository.findById(id);
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return this.itemRepository.findAll();
	}

	@Override
	public List<Item> findByItemStatus() {
		// TODO Auto-generated method stub
		return this.itemRepository.findByItemStatus();
	}

	@Override
	public List<Item> findByItemStatusAprovado() {
		// TODO Auto-generated method stub
		return this.itemRepository.findByItemStatusAprovado();
	}

	@Override
	public void deleteAll(List<Item> list) {
		// TODO Auto-generated method stub
		this.itemRepository.deleteAll(list);
	}

	
}
