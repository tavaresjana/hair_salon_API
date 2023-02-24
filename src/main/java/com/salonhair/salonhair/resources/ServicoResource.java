package com.salonhair.salonhair.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salonhair.salonhair.entities.ServicoModel;
import com.salonhair.salonhair.services.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

	@Autowired
	private ServicoService servicoService;

	@GetMapping
	public ResponseEntity<List<ServicoModel>> findAll(){
		List<ServicoModel> list = servicoService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ServicoModel> findById(@PathVariable Long id){
		ServicoModel obj = servicoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
