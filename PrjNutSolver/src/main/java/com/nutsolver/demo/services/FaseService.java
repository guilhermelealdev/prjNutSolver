package com.nutsolver.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutsolver.demo.entities.Avatar;
import com.nutsolver.demo.entities.Fase;
import com.nutsolver.demo.repositories.FaseRepository;

@Service
public class FaseService {
	private FaseRepository faseRepository;

	@Autowired
	public FaseService(FaseRepository faseRepository) {
		this.faseRepository = faseRepository;
	}
	
	public Fase salvarFase(Fase fase) {
		return faseRepository.save(fase);
	}
	
	
	public Fase getFase(Long idFase) {
		return faseRepository.findById(idFase).orElse(null);
	}
	
	public List<Fase> listarFases(){
		return faseRepository.findAll();
	}
	
	
	public void deletarFaseById( Long idUsuario) {
		faseRepository.deleteById(idUsuario);
	}
	
	public Fase atualizarFaseById(Long idFase, Fase faseAtualizada) {
		
		Optional<Fase>  faseOptional = faseRepository.findById(idFase);
		
		if(faseOptional.isPresent()) {
			Fase fase = faseOptional.get();
			
			fase.setValor(faseAtualizada.getValor());
			fase.setQuestoes(faseAtualizada.getQuestoes());
			
			return faseRepository.save(fase);
			
		}else {
			return null;
		}
	}
	
	
	
}
