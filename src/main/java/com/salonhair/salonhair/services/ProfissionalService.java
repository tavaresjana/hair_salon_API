package com.salonhair.salonhair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salonhair.salonhair.entities.ProfissionalModel;
import com.salonhair.salonhair.repositories.ProfissionalRepository;


@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public List<ProfissionalModel> findAll(){
		
		return profissionalRepository.findAll();
	}

	public ProfissionalModel findById(long id) {
		Optional<ProfissionalModel> obj = profissionalRepository.findById(id);
		return obj.get();
	}
	
	public ProfissionalModel insert(ProfissionalModel obj) {
		return profissionalRepository.save(obj);
	}
	
	public ProfissionalModel update(Long id, ProfissionalModel obj) {
		ProfissionalModel entity = profissionalRepository.getReferenceById(id);
		updateData(entity,obj);
		return profissionalRepository.save(entity);
	}
	
	public void updateData(ProfissionalModel entity,ProfissionalModel obj) {
		entity.setMatricula(obj.getMatricula());
		entity.setNome(obj.getNome());
		entity.setEspecialidade(obj.getEspecialidade());
		
	}

}
