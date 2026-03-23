package com.nutsolver.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutsolver.demo.entities.Fase;
import com.nutsolver.demo.entities.Questao;
import com.nutsolver.demo.repositories.FaseRepository;

@Service
public class FaseService {

	@Autowired
	private FaseRepository faseRepository;

	public Fase salvarFase(Fase fase) {

		// 🔥 garante o relacionamento
		for (Questao q : fase.getQuestoes()) {
			q.setFase(fase);
		}

		return faseRepository.save(fase);
	}

	public Fase getFase(Long idFase) {
		return faseRepository.findById(idFase).orElse(null);
	}

	public List<Fase> listarFases() {
		return faseRepository.findAll();
	}

	public void deletarFaseById(Long idFase) {
		faseRepository.deleteById(idFase);
	}

	public Fase atualizarFaseById(Long idFase, Fase novaFase) {
		Fase existente = getFase(idFase);

		if (existente != null) {
			// atualiza valor da fase
			existente.setValor(novaFase.getValor());

			// remove todas as questões antigas
			existente.getQuestoes().clear();

			// adiciona as novas questões, garantindo o relacionamento bidirecional
			for (Questao q : novaFase.getQuestoes()) {
				existente.addQuestao(q);
			}

			// salva e retorna
			return faseRepository.save(existente);
		}

		return null;
	}
}