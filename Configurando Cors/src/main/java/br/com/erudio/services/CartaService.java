package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Carta;
import br.com.erudio.data.vo.v1.CartaVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.CartaRepository;
import br.com.erudio.services.validator.CartaValidator;
import br.com.erudio.services.validator.Validator;

@Service
public class CartaService {

	@Autowired
	CartaRepository repository;
	
	public CartaVO created(CartaVO carta) {
		validarRegrasDoJogo(new CartaValidator(), carta);
		var entity = DozerConverter.parseObject(carta, Carta.class);
		var vo = DozerConverter.parseObject(repository.save(entity),CartaVO.class);
		return vo;
	}
	
	public List<CartaVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), CartaVO.class) ;
	}
	
	public CartaVO findById(Long id) {
		
		var entity =  repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		return DozerConverter.parseObject(entity, CartaVO.class);
	}
	
	public CartaVO update(CartaVO carta) {
		var entity = repository.findById(carta.getKey())
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		entity.setNome(carta.getNome());
		entity.setDescricao(carta.getDescricao());
		entity.setAtaque(carta.getAtaque());
		entity.setDefesa(carta.getDefesa());
		entity.setTipo(carta.getTipo());
		entity.setClasse(carta.getClasse());

		var vo = DozerConverter.parseObject(repository.save(entity),CartaVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Carta entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		repository.delete(entity);
		
	}
	
	private <T> void validarRegrasDoJogo(Validator<T> validator, T objeto) {
		validator.valida(objeto);
	}
	
}
