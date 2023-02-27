package com.salonhair.salonhair.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salonhair.salonhair.entities.ClienteModel;
import com.salonhair.salonhair.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteModel>> findAll(){
		//ClienteModel u = new ClienteModel(1L, "Maria", "maria@gmail.com","9999999", "12345");
		List<ClienteModel> list = clienteService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteModel> findById(@PathVariable Long id){
		ClienteModel obj = clienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	 public ResponseEntity<ClienteModel> insert(@RequestBody ClienteModel obj){
	 obj = clienteService.insert(obj);
	 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			 .buildAndExpand(obj.getId()).toUri();
	 return ResponseEntity.created(uri).body(obj);
	 }
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteModel> update(@PathVariable Long id, @RequestBody ClienteModel obj){
		obj = clienteService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
