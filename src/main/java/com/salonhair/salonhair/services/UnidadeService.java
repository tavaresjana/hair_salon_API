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
	

}
