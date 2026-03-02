package com.nutsolver.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	private String username;
	private int nozes;
	private String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(Long idUsuario, String username, int nozes, String senha) {
		this.idUsuario = idUsuario;
		this.username = username;
		this.nozes = nozes;
		this.senha = senha;
	}

	public Long getId() {
		return idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getNozes() {
		return nozes;
	}

	public void setNozes(int nozes) {
		this.nozes = nozes;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
