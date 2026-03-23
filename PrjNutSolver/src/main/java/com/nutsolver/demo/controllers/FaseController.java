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

import com.nutsolver.demo.entities.Fase;
import com.nutsolver.demo.services.FaseService;

@RestController
@RequestMapping("/fases")
public class FaseController {

	
	private FaseService faseService;
	
	
	@Autowired
	public FaseController(FaseService faseService) {
		this.faseService = faseService;
	}

	@PostMapping("/salvar")
	public Fase criarFase(@RequestBody Fase fase) {
		return faseService.salvarFase(fase);
	}

	@GetMapping("/{id}")
	public Fase buscarPorId(@PathVariable Long id) {
		return faseService.getFase(id);
	}

	@GetMapping
	public List<Fase> listar() {
		return faseService.listarFases();
	}

	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Long id) {
		faseService.deletarFaseById(id);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Fase> atualizar(@PathVariable Long id, @RequestBody Fase fase) {
		Fase atualizado = faseService.atualizarFaseById(id, fase);

		if (atualizado != null) {
			return ResponseEntity.ok(atualizado);
		}

		return ResponseEntity.notFound().build();
	}
}
