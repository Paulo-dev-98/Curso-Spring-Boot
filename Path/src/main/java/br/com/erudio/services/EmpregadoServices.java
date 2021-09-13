package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Empregado;
import br.com.erudio.data.vo.v1.EmpregadoVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.EmpregadoRepository;

@Service
public class EmpregadoServices {
	
	@Autowired
	EmpregadoRepository repository;
	
	public EmpregadoVO created(EmpregadoVO empregado) {
		var entity = DozerConverter.parseObject(empregado, Empregado.class);
		var vo = DozerConverter.parseObject(repository.save(entity),EmpregadoVO.class);
		return vo;
	}
	
	public List<EmpregadoVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), EmpregadoVO.class) ;
	}
	
	public EmpregadoVO findById(Long id) {
		
		var entity =  repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		return DozerConverter.parseObject(entity, EmpregadoVO.class);
	}
	
	public EmpregadoVO update(EmpregadoVO empregado) {
		var entity = repository.findById(empregado.getKey())
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		entity.setNome(empregado.getNome());
		entity.setCpf(empregado.getCpf());
		var vo = DozerConverter.parseObject(repository.save(entity),EmpregadoVO.class);
		return vo;
	}

	public void delete(Long id) {
		Empregado entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		repository.delete(entity);
		
	}
	
}
