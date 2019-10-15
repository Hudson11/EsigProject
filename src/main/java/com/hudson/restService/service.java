package com.hudson.restService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hudson.Dao.IClienteDao;
import com.hudson.Dao.IUsuarioDao;
import com.hudson.Dao.IitemDao;
import com.hudson.model.Cliente;
import com.hudson.model.Item;
import com.hudson.model.Usuario;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "*")
public class service {
	
	@Autowired
	private IitemDao itemDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List <Item> findAll(){
		return itemDao.findAll();
	}
	
//	@GetMapping
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public List<Item> findAllByActives(){
//		return itemDao.findByItemStatusAprovado();
//	}
//	
//	@GetMapping
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public List<Item> findAllByCompleted(){
//		return itemDao.findByItemStatus();
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void createOrUpdate(@RequestBody Usuario c) {
		try {
			clienteDao.save(c.getCliente());
			usuarioDao.save(c);
		}finally {
			
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Long id) {
		itemDao.deleteById(id);
	}
	
}
