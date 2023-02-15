package com.salonhair.salonhair.services;

import java.util.List;

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
	};
	
	

}
