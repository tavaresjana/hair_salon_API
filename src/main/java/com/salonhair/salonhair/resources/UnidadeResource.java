package com.salonhair.salonhair.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salonhair.salonhair.entities.UnidadeModel;
import com.salonhair.salonhair.services.UnidadeService;

@RestController
@RequestMapping(value ="/unidades")
public class UnidadeResource {
	
	@Autowired
	private UnidadeService unidadeService;
	
	@GetMapping
	public ResponseEntity<List<UnidadeModel>> findAll(){
		
		 List<UnidadeModel> list = unidadeService.findAll();
		 
		 return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<UnidadeModel> findById(@PathVariable("id") Long id){
		
		UnidadeModel obj = unidadeService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<UnidadeModel> insert(@RequestBody UnidadeModel obj){
		obj = unidadeService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	
}
