package com.nutsolver.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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

	private Integer valor;

	@OneToMany(mappedBy = "fase", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Questao> questoes = new ArrayList<>();

	public Fase() {

	}	

	public Fase(Long idFase, Integer valor, List<Questao> questoes) {
		super();
		this.idFase = idFase;
		this.valor = valor;
		this.questoes = questoes;
	}
	
	public Long getIdFase() {
		return idFase;
	}

	public void setIdFase(Long idFase) {
		this.idFase = idFase;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	// 🔥 método helper para gerenciar o relacionamento
    public void addQuestao(Questao q) {
        questoes.add(q);
        q.setFase(this);
    }

    public void removeQuestao(Questao q) {
        questoes.remove(q);
        q.setFase(null);
    }

}
