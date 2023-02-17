package com.salonhair.salonhair.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.salonhair.salonhair.entities.ClienteModel;
import com.salonhair.salonhair.entities.UnidadeModel;
import com.salonhair.salonhair.repositories.ClienteRepository;
import com.salonhair.salonhair.repositories.UnidadeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner  {
	
	@Autowired 
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		UnidadeModel u1 = new UnidadeModel(null,"Guape",23,"Serodio","Guarulhos","Sp");
		UnidadeModel u2 = new UnidadeModel(null,"Uva",100,"Vila dos uvas","Uvanópolis","Sp");
		
		unidadeRepository.saveAll(Arrays.asList(u1));
		unidadeRepository.saveAll(Arrays.asList(u2));
		
		//testes referente a entidade cliente
		ClienteModel c1 = new ClienteModel(null, "Jana Java", "janajava@email.com", "senha123", 445335000, 91111111);
		ClienteModel c2 = new ClienteModel(null, "Ana Nodejs", "ananodejs@email.com", "senha123", 445335001, 91111112);
		
		clienteRepository.saveAll(Arrays.asList(c1));
		clienteRepository.saveAll(Arrays.asList(c2));
	}

}
