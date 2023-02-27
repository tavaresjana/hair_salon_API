package com.salonhair.salonhair.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.salonhair.salonhair.entities.ClienteModel;
import com.salonhair.salonhair.entities.ProfissionalModel;
import com.salonhair.salonhair.entities.ServicoModel;
import com.salonhair.salonhair.entities.UnidadeModel;
import com.salonhair.salonhair.repositories.ClienteRepository;
import com.salonhair.salonhair.repositories.ProfissionalRepository;
import com.salonhair.salonhair.repositories.ServicoRepository;
import com.salonhair.salonhair.repositories.UnidadeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner  {
	
	@Autowired 
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//testes referente a entidade unidade
		UnidadeModel u1 = new UnidadeModel(null,"Guape",23,"Serodio","Guarulhos","Sp");
		UnidadeModel u2 = new UnidadeModel(null,"Uva",100,"Vila dos uvas","Uvanópolis","Sp");
		
		unidadeRepository.saveAll(Arrays.asList(u1));
		unidadeRepository.saveAll(Arrays.asList(u2));
		
		//testes referente a entidade cliente
		ClienteModel c1 = new ClienteModel(null, "Jana Java", "janajava@email.com", "senha123", "384.883.170-85", 91111111);
		ClienteModel c2 = new ClienteModel(null, "Ana Nodejs", "ananodejs@email.com", "senha123", "380.985.080-21", 91111112);
				
		clienteRepository.saveAll(Arrays.asList(c1));
		clienteRepository.saveAll(Arrays.asList(c2));
		
		//testes referente a entidade Serviço
		ServicoModel s1 = new ServicoModel(null, "Escova", 70.00);
		ServicoModel s2 = new ServicoModel(null, "Hidratação", 80.00);
		ServicoModel s3 = new ServicoModel(null, "Corte", 50.00);
		ServicoModel s4 = new ServicoModel(null, "Coloração", 120.00);
		
		servicoRepository.saveAll(Arrays.asList(s1));
		servicoRepository.saveAll(Arrays.asList(s2));
		servicoRepository.saveAll(Arrays.asList(s3));
		servicoRepository.saveAll(Arrays.asList(s4));
		
		//testes referente a entidade Profissional
		
				ProfissionalModel p1 = new ProfissionalModel(null, 1234, "João Carlo","Barba e Cabelo");
				ProfissionalModel p2 = new ProfissionalModel(null, 4562, "Otávio","Corte feminino e sobrancelha");
				ProfissionalModel p3 = new ProfissionalModel(null, 8546, "Sandro","Corte masculino e feminino");
				ProfissionalModel p4 = new ProfissionalModel(null, 4246, "Juarez","Corte masculino e feminino");
				
				profissionalRepository.saveAll(Arrays.asList(p1));
				profissionalRepository.saveAll(Arrays.asList(p2));
				profissionalRepository.saveAll(Arrays.asList(p3));
				profissionalRepository.saveAll(Arrays.asList(p4));
	}

}
