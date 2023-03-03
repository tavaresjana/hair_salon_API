package com.salonhair.salonhair.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_unidade")
public class UnidadeModel implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "unidade", targetEntity = ProfissionalModel.class)
	private List<ProfissionalModel> profissional = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "tb_unidade_servico",
	joinColumns = @JoinColumn(name ="unidade_id"), 
	inverseJoinColumns = @JoinColumn(name = "servico_id"))
	private Set<ServicoModel> servicoModel = new HashSet<>();
	
	public UnidadeModel() {
		
	}

	public UnidadeModel(Long id, String rua, Integer numero, String bairro, String cidade, String estado) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Set<ServicoModel> getServicoModel() {
		return servicoModel;
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
		UnidadeModel other = (UnidadeModel) obj;
		return Objects.equals(id, other.id);
	}



	
	

}
