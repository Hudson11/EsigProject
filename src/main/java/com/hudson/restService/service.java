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
import com.hudson.model.Cliente;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class service {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List <Cliente> findAll(){
		return clienteDao.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void createOrUpdate(@RequestBody Cliente c) {
		clienteDao.save(c);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Long id) {
		clienteDao.deleteById(id);
	}
	
}
