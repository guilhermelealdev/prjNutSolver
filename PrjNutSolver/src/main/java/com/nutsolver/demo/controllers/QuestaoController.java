package com.nutsolver.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutsolver.demo.entities.Questao;
import com.nutsolver.demo.services.QuestaoService;

@RestController
@RequestMapping("/fase/questoes")
public class QuestaoController {
	
	private QuestaoService questaoService;

	@Autowired
	public QuestaoController(QuestaoService questaoService) {
		this.questaoService = questaoService;
	}
	
	@PostMapping("/salvar")
	public Questao SaveQuestao(@RequestBody Questao questao) {
		return questaoService.salvarQuestao(questao);
	}
	
	@DeleteMapping("/deletar/{idQuestao}")
	public void DeleteQuestao(@PathVariable Long idQuestao) {
		questaoService.deletarQuestao(idQuestao);
	}
	
	@GetMapping("/buscar/{idQuestao}")
	public Questao GetQuestao(@PathVariable Long idQuestao) {
		return questaoService.getQuestaoById(idQuestao);
	}
	
	

}
