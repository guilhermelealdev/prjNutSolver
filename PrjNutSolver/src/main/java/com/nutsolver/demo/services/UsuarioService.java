package com.nutsolver.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nutsolver.demo.entities.Usuario;
import com.nutsolver.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	
	public Usuario salvarUsuario( Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	public Usuario getUsuarioById( Long idUsuario) {
		return usuarioRepository.findById(idUsuario).orElse(null);
	}
	
	
	
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	
	public void deletarUsuarioById( Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}
	
	
	
	public Usuario atualizarUsuarioById(Long idUsuario, Usuario usuarioAtualizado) {
		
		Optional<Usuario>  usuarioOptional = usuarioRepository.findById(idUsuario);
		
		if(usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();
			
			usuario.setNozes(usuarioAtualizado.getNozes());
			usuario.setSenha(usuarioAtualizado.getSenha());
			usuario.setUsername(usuarioAtualizado.getUsername());
			
			return usuarioRepository.save(usuario);
		}else {
			return null;
		}
		
	}
	

}
