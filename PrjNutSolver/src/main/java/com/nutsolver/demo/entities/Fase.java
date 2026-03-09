package com.nutsolver.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_fases")
public class Fase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFase;

	private int valor;

	@OneToMany
	private Questao[] questoes = new Questao[2];

	public Fase(Long idFase, int valor, Questao[] questoes) {
		this.idFase = idFase;
		this.valor = valor;
		this.questoes = questoes;
	}

	public Long getIdFase() {
		return idFase;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Questao[] getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Questao[] questoes) {
		this.questoes = questoes;
	}
	
	

}
