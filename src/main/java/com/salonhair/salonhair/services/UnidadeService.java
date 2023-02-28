package com.salonhair.salonhair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.salonhair.salonhair.entities.UnidadeModel;
import com.salonhair.salonhair.repositories.UnidadeRepository;

@Service
public class UnidadeService {
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public List<UnidadeModel> findAll(){
		
		return unidadeRepository.findAll();
	}

	public UnidadeModel findById(long id) {
		Optional<UnidadeModel> obj = unidadeRepository.findById(id);
		return obj.get();
	}
	
	
	public UnidadeModel insert(UnidadeModel obj) {
		return unidadeRepository.save(obj);
	}
	
	public UnidadeModel update(Long id, UnidadeModel obj) {
		UnidadeModel entity = unidadeRepository.getReferenceById(id);
		updateData(entity,obj);
		return unidadeRepository.save(entity);
	}
	public void updateData(UnidadeModel entity, UnidadeModel obj) {
		entity.setRua(obj.getRua());
		entity.setNumero(obj.getNumero());
		entity.setBairro(obj.getBairro());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
	}

}
