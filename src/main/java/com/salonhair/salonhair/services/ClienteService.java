package com.salonhair.salonhair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salonhair.salonhair.entities.ClienteModel;
import com.salonhair.salonhair.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteModel> findAll() {
		return clienteRepository.findAll();
	}

	public ClienteModel findById(Long id) {
		Optional<ClienteModel> obj = clienteRepository.findById(id);
		return obj.get();
	}
	
	public ClienteModel insert(ClienteModel obj) {
		return clienteRepository.save(obj);
	}
	
	public ClienteModel update(Long id, ClienteModel obj) {
		ClienteModel entity = clienteRepository.getReferenceById(id);
		updateData(entity, obj);
		return clienteRepository.save(entity);
	}

	private void updateData(ClienteModel entity, ClienteModel obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setSenha(obj.getSenha());
		entity.setTelefone(obj.getTelefone());	
	}

}
