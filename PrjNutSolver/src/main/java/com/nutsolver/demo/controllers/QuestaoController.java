package com.nutsolver.demo.controllers;

import java.util.List;

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
@RequestMapping("/questoes")
public class QuestaoController {

    
    private QuestaoService questaoService;
    
    
    @Autowired
    public QuestaoController(QuestaoService questaoService) {
		this.questaoService = questaoService;
	}

	@PostMapping
    public Questao salvar(@RequestBody Questao questao) {
        return questaoService.salvarQuestao(questao);
    }

    @GetMapping("/{id}")
    public Questao buscar(@PathVariable Long id) {
        return questaoService.getQuestaoById(id);
    }

    @GetMapping
    public List<Questao> listar() {
        return questaoService.listarQuestoes();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        questaoService.deletarQuestao(id);
    }
}
