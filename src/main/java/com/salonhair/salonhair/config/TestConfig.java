package com.salonhair.salonhair.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.salonhair.salonhair.entities.UnidadeModel;
import com.salonhair.salonhair.repositories.UnidadeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner  {
	
	@Autowired 
	private UnidadeRepository unidadeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		UnidadeModel u1 = new UnidadeModel(null,"Guape",23,"Serodio","Guarulhos","Sp");
		UnidadeModel u2 = new UnidadeModel(null,"Uva",100,"Vila dos uvas","Uvanópolis","Sp");
		
		unidadeRepository.saveAll(Arrays.asList(u1));
		unidadeRepository.saveAll(Arrays.asList(u2));
	}

}
