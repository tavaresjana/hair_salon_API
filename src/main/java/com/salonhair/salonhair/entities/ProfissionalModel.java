package com.salonhair.salonhair.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_PROFISSIONAL")
public class ProfissionalModel implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer matricula;
	private String nome;
	private String especialidade;
	
	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private ServicoModel servico;
	
	
	public ProfissionalModel() {
		
	}
	
	public ProfissionalModel(Long id, Integer matricula, String nome, String especialidade, ServicoModel servico) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.especialidade = especialidade;
		this.servico = servico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	

	public ServicoModel getServico() {
		return servico;
	}

	public void setServico(ServicoModel servico) {
		this.servico = servico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfissionalModel other = (ProfissionalModel) obj;
		return Objects.equals(id, other.id);
	}
	
	
	


}