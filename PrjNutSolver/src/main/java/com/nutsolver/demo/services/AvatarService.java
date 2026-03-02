package com.nutsolver.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nutsolver.demo.entities.Avatar;
import com.nutsolver.demo.repositories.AvatarRepository;

@Service
public class AvatarService {

	private AvatarRepository avatarRepository;
	
	@Autowired
	public AvatarService(AvatarRepository avatarRepository) {
		this.avatarRepository = avatarRepository;
	}
	
	@PostMapping("/salvar")
	public Avatar salvarAvatar(Avatar avatar) {
		return avatarRepository.save(avatar);
	}

	public Avatar getAvatarPorId(Long idAvatar) {
		return avatarRepository.findById(idAvatar).orElse(null);
	}
	
	public void deletarAvatarPorId(Long idAvatar) {
		avatarRepository.deleteById(idAvatar);
	}

	public Avatar atualizarAvatarById(@PathVariable Long idAvatar,@RequestBody Avatar avatarAtualizado) {
		
		Optional<Avatar> avatarOptional = avatarRepository.findById(idAvatar);

		if (avatarOptional.isPresent()) {
			
			Avatar avatar = avatarOptional.get();

			avatar.setImagem(avatarAtualizado.getImagem());
			
			return avatarRepository.save(avatar);
		} else {
			return null;
		}
	}

}
