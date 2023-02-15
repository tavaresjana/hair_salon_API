package com.salonhair.salonhair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salonhair.salonhair.entities.ClienteModel;
import com.salonhair.salonhair.repositories.ClienteRepository;

import jakarta.validation.Valid;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteModel> findAll() {
		return clienteRepository.findAll();
	}

	public Optional<ClienteModel> findById(Long id) {
		return clienteRepository.findById(id);
	}


	public ClienteModel save(@Valid ClienteModel clienteModel) {
		return clienteRepository.save(clienteModel);
	}

	public void delete(ClienteModel clienteModel) {
		clienteRepository.delete(clienteModel);
	}

}