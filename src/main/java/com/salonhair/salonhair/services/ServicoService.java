package com.salonhair.salonhair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salonhair.salonhair.entities.ServicoModel;
import com.salonhair.salonhair.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public List<ServicoModel> findAll() {
		return servicoRepository.findAll();
	}

	public ServicoModel findById(Long id) {
		Optional<ServicoModel> obj = servicoRepository.findById(id);
		return obj.get();
	}

}
