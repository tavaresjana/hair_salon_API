package com.salonhair.salonhair.dto;

import java.io.Serializable;

import com.salonhair.salonhair.entities.ServicoModel;

public class ServicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String tipo;
	private Double preco;
	
	public ServicoDTO() {
		
	}
	
	public ServicoDTO(ServicoModel obj) {
		id = obj.getId();
		tipo = obj.getTipo();
		preco = obj.getPreco();
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
	
	
}
