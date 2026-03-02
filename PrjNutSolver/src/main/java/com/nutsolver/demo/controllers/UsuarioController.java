package com.nutsolver.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutsolver.demo.entities.Usuario;
import com.nutsolver.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/criar")
	public Usuario CriarUsuario(@PathVariable Usuario usuario) {
		return usuarioService.salvarUsuario(usuario);
	}

	@GetMapping("/{idUsuario}")
	public Usuario BuscarPorId(@PathVariable Long idUsuario) {
		return usuarioService.getUsuarioById(idUsuario);
	}

	@DeleteMapping("/deletar/{idUsuario}")
	public void DeletarUsuarioPorId(@PathVariable Long idUsuario) {
		usuarioService.deletarUsuarioById(idUsuario);
	}

	public List<Usuario> ListarTodosUsuarios() {
		return usuarioService.listarUsuarios();
	}
	
	@PutMapping("/atualizar/{idUsuario}")
	public ResponseEntity<Usuario> AtualizarUsuario(@PathVariable Long idUsuario, @RequestBody Usuario usuario) {
		Usuario atualizado = usuarioService.atualizarUsuarioById(idUsuario, usuario);
		
		if (atualizado != null) {
			return ResponseEntity.ok(atualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
