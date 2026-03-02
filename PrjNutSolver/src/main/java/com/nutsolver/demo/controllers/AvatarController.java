package com.nutsolver.demo.controllers;

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

import com.nutsolver.demo.entities.Avatar;
import com.nutsolver.demo.services.AvatarService;

@RestController
@RequestMapping("/usuarios/avatar")
public class AvatarController {

	private final AvatarService avatarService;
	
	@Autowired
	public AvatarController(AvatarService avatarService) {
		this.avatarService = avatarService;
	}
	
	@PostMapping("/salvar")
	public Avatar SalvarAvatar(@RequestBody Avatar avatar) {
		return avatarService.salvarAvatar(avatar);
	}
	
	@DeleteMapping("/deletar/{idAvatar}")
	public void ApagarAvatar(@PathVariable Long idAvatar) {
		avatarService.deletarAvatarPorId(idAvatar);
	}
	
	@GetMapping("/{idAvatar}")
	public Avatar GetAvatar(@PathVariable Long idAvatar) {
		return avatarService.getAvatarPorId(idAvatar);
	}
	
	@PutMapping("/atualizar/{idAvatar}")
	public ResponseEntity<Avatar> AtualizarAvatar(@PathVariable Long idAvatar, @RequestBody Avatar avatar) {
		Avatar atualizado = avatarService.atualizarAvatarById(idAvatar, avatar);
		
		if (atualizado != null) {
			return ResponseEntity.ok(atualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
