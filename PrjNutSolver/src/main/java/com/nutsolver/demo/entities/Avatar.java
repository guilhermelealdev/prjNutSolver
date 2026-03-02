package com.nutsolver.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_avatares")
public class Avatar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAvatar;
	
	String imagem;

	@ManyToOne
	private Usuario usuario;

	public Avatar(Long idAvatar, String imagem, Usuario usuario) {
		this.idAvatar = idAvatar;
		this.usuario = usuario;
	}

	public Long getIdAvatar() {
		return idAvatar;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
