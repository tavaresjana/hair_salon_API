package com.salonhair.salonhair.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agendamento")
public class AgendamentoModel {
	
	private ClienteModel CPF;
	private Date time;
	private UnidadeModel unidade;
	private ProfissionalModel matricula;
	
	public AgendamentoModel() {
	}
	
	public AgendamentoModel(ClienteModel cPF, Date time, UnidadeModel unidade, ProfissionalModel matricula) {
		super();
		CPF = cPF;
		this.time = time;
		this.unidade = unidade;
		this.matricula = matricula;
	}
	
	public ClienteModel getCPF() {
		return CPF;
	}
	public void setCPF(ClienteModel cPF) {
		CPF = cPF;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public UnidadeModel getUnidade() {
		return unidade;
	}
	public void setUnidade(UnidadeModel unidade) {
		this.unidade = unidade;
	}
	public ProfissionalModel getMatricula() {
		return matricula;
	}
	public void setMatricula(ProfissionalModel matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CPF);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendamentoModel other = (AgendamentoModel) obj;
		return Objects.equals(CPF, other.CPF);
	}
	
	
}
