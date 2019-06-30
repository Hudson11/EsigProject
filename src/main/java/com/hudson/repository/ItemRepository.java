package com.hudson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.hudson.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	@Query(value = "SELECT * FROM  item c WHERE c.status = false", nativeQuery = true)
	List <Item> findByItemStatus();
	
	@Query(value = "SELECT * FROM  item c WHERE c.status = true", nativeQuery = true)
	List <Item> findByItemStatusAprovado();
	
}
