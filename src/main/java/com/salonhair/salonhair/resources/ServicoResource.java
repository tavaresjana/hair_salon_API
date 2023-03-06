package com.salonhair.salonhair.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.salonhair.salonhair.dto.ServicoDTO;
import com.salonhair.salonhair.entities.ServicoModel;
import com.salonhair.salonhair.services.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

	@Autowired
	private ServicoService servicoService;

	@GetMapping
	public ResponseEntity<List<ServicoDTO>> findAll(){
		List<ServicoModel> list = servicoService.findAll();
		List<ServicoDTO> listDto = list.stream().map(x -> new ServicoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ServicoModel> findById(@PathVariable Long id){
		ServicoModel obj = servicoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<ServicoModel> insert(@RequestBody ServicoModel obj){
		 obj = servicoService.insert(obj);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				 .buildAndExpand(obj.getId()).toUri();
		 return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ServicoModel> update(@PathVariable Long id, @RequestBody ServicoModel obj){
		obj = servicoService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
