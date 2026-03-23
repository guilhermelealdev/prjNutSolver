package com.nutsolver.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutsolver.demo.entities.Questao;
import com.nutsolver.demo.repositories.QuestaoRepository;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    public Questao salvarQuestao(Questao questao) {
        return questaoRepository.save(questao);
    }

    public void deletarQuestao(Long idQuestao) {
        questaoRepository.deleteById(idQuestao);
    }

    public Questao getQuestaoById(Long idQuestao) {
        return questaoRepository.findById(idQuestao).orElse(null);
    }

    public List<Questao> listarQuestoes() {
        return questaoRepository.findAll();
    }
}