package com.salonhair.salonhair.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salonhair.salonhair.entities.ProfissionalModel;
import com.salonhair.salonhair.entities.UnidadeModel;
import com.salonhair.salonhair.services.ProfissionalService;
import com.salonhair.salonhair.services.UnidadeService;

@RestController
@RequestMapping(value ="/profissional")
public class ProfissionalResource {
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@GetMapping
	public ResponseEntity<List<ProfissionalModel>> findAll(){
		
		 List<ProfissionalModel> list = profissionalService.findAll();
		 
		 return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfissionalModel> findById(@PathVariable("id") Long id){
		
		ProfissionalModel obj = profissionalService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
