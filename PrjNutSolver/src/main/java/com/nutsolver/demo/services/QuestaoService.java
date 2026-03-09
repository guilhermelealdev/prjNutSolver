package com.nutsolver.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutsolver.demo.entities.Questao;
import com.nutsolver.demo.repositories.QuestaoRepository;

@Service
public class QuestaoService {
	private QuestaoRepository questaoRepository;

	@Autowired
	public QuestaoService(QuestaoRepository questaoRepository) {
		this.questaoRepository = questaoRepository;
	}
	
	public Questao salvarQuestao(Questao questao) {
		return questaoRepository.save(questao);
	}
	
	public void deletarQuestao(Long idQuestao) {
		questaoRepository.deleteById(idQuestao);
	}
	
	public Questao getQuestaoById(Long idQuestao) {
		return questaoRepository.findById(idQuestao).orElse(null);
	}

}
