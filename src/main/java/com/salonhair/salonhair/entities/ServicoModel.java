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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_servico")
public class ServicoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String tipo;
	private Double preco;
	
	@JsonIgnore
    @OneToMany(mappedBy = "servico",targetEntity = ProfissionalModel.class )
	private List<ProfissionalModel> profissional = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "servicoModel")
	private Set<UnidadeModel> unidadeModel = new HashSet<>();
	
	
	public ServicoModel() {
	}

	public ServicoModel(Long id, String tipo, Double preco) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public List<ProfissionalModel> getProfissional(){
		return profissional;
	}
	public Set<UnidadeModel> getUnidadeModel() {
		return unidadeModel;
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
		ServicoModel other = (ServicoModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ServicoModel [id=" + id + ", tipo=" + tipo + ", preco=" + preco + "]";
	}

}
