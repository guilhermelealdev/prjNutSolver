package com.nutsolver.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutsolver.demo.entities.Fase;
import com.nutsolver.demo.entities.Usuario;
import com.nutsolver.demo.services.FaseService;

@RestController
@RequestMapping("/fase")
public class FaseController {
	
	private FaseService faseService;
	
	@PostMapping("/criar")
	public Fase CriarUsuario(@PathVariable Fase fase) {
		return faseService.salvarFase(fase);
	}

	@GetMapping("/{idFase}")
	public Fase BuscarPorId(@PathVariable Long idFase) {
		return faseService.getFase(idFase);
	}

	@DeleteMapping("/deletar/{idFase}")
	public void DeletarUsuarioPorId(@PathVariable Long idUsuario) {
		faseService.deletarFaseById(idUsuario);
	}

	public List<Fase> ListarTodasFases() {
		return faseService.listarFases();
	}
	
	@PutMapping("/atualizar/{idFase}")
	public ResponseEntity<Fase> AtualizarFase(@PathVariable Long idFase, @RequestBody Fase fase) {
		Fase atualizado = faseService.atualizarFaseById(idFase, fase);
		
		if (atualizado != null) {
			return ResponseEntity.ok(atualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
