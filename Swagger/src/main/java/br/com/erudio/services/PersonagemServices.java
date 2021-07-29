package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Personagem;
import br.com.erudio.data.vo.v1.PersonagemVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.PersonagemRepository;

@Service
public class PersonagemServices {
	
	@Autowired
	PersonagemRepository repository;
	
	public PersonagemVO created(PersonagemVO personagem) {
		var entity = DozerConverter.parseObject(personagem, Personagem.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonagemVO.class);
		return vo;
	}
	
	public List<PersonagemVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), PersonagemVO.class);
	}
	
	public PersonagemVO findById(Long id) {
		var entity = repository.findById(id);
		return DozerConverter.parseObject(entity, PersonagemVO.class);
	}
	
	public PersonagemVO update(PersonagemVO personagem) {
		var entity = repository.findById(personagem.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("id não encontrado"));
		entity.setNome(personagem.getNome());
		entity.setIdade(personagem.getIdade());
		entity.setSexo(personagem.getSexo());
		entity.setUniverso(personagem.getUniverso());
		entity.setOrigem(personagem.getOrigem());
		entity.setHabitação(personagem.getHabitação());
		entity.setPersonalidade(personagem.getPersonalidade());
		entity.setPoder(personagem.getPoder());
		entity.setFraseDeEfeitoNumero1(personagem.getFraseDeEfeitoNumero1());
		entity.setFraseDeEfeitoNumero2(personagem.getFraseDeEfeitoNumero2());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonagemVO.class);
		return vo;
	}
	
	
	public void delete(Long id) {
		Personagem entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		repository.delete(entity);
		
	}

}
