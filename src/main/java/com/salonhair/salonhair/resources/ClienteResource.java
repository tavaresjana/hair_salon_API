package com.salonhair.salonhair.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salonhair.salonhair.entities.ClienteModel;
import com.salonhair.salonhair.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteModel>> findAll() {
		List<ClienteModel> list = clienteService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> postClienteModel(@Valid @RequestBody ClienteModel clienteModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Long id) {
		Optional<ClienteModel> ClienteModelOptional = clienteService.findById(id);
		if (!ClienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		clienteService.delete(ClienteModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
	}
}
