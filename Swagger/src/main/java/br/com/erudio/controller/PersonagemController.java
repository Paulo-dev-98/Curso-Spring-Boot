package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonagemVO;
import br.com.erudio.services.PersonagemServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "EndPoint de Personagens" , description = "cadastra um catagologo de personagens.", tags = {"personagemController"})
@RestController
@RequestMapping("/api/personagem/v1")
public class PersonagemController {

	@Autowired
	PersonagemServices service;
	
	@ApiOperation(value = "busca todos os personagens")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<PersonagemVO> findAll() {
		List<PersonagemVO> personagem = service.findAll();
		personagem.stream().forEach(pp -> pp.add(linkTo(methodOn(PersonagemController.class).findById(pp.getKey())).withSelfRel()));
		return personagem;
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PersonagemVO findById(@PathVariable("id") Long id) {
		PersonagemVO personagemVo = service.findById(id);
		personagemVo.add(linkTo(methodOn(PersonagemController.class).findById(id)).withSelfRel());
		return personagemVo;
	}
	
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
		         consumes = { "application/json", "application/xml", "application/x-yaml" })
    public PersonagemVO create(@RequestBody PersonagemVO personagem) {
		   PersonagemVO personagemVo = service.created(personagem);
	personagemVo.add(linkTo(methodOn(PersonagemController.class).findById(personagemVo.getKey())).withSelfRel());
	return personagemVo;
    }
	
	@PutMapping(produces = {"application/json" , "application/xml", "application/x-yaml"}, 
                consumes = {"application/json" , "application/xml", "application/x-yaml"})
    public PersonagemVO update(@RequestBody PersonagemVO personagem) {
		   PersonagemVO personagemVo = service.update(personagem);
    personagemVo.add(linkTo(methodOn(PersonagemController.class).findById(personagemVo.getKey())).withSelfRel());
    return personagemVo;
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
