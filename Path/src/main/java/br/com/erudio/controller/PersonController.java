package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@CrossOrigin
@Api(tags = "EndpointPersonagem")
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonServices service;
	
	@ApiOperation(value = "busca todos os persons")
	@GetMapping(produces = {"application/json" , "application/xml","application/x-yaml"})
	public List<PersonVO> findAll() {
		List<PersonVO> persons = service.findAll();
		persons
		  .stream()
		   .forEach(p -> p.add(
				   linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
				       )
				   );
		return persons;
	}	
	
//	@CrossOrigin(origins = "http://localhost:8080") habilitando o cors
	@ApiOperation(value = "busca persons por id")
	@GetMapping(value = "/{id}", produces = {"application/json" , "application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id) {
		PersonVO personVo = service.findById(id);
		personVo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVo;
	}	
	
	@ApiOperation(value = "cadastrar persons")
	@PostMapping(produces = {"application/json" , "application/xml" , "application/x-yaml"}, 
			     consumes = {"application/json" , "application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person) {
		PersonVO personVo = service.created(person);
		personVo.add(linkTo(methodOn(PersonController.class).findById(personVo.getKey())).withSelfRel());
		return personVo;
	}
	
	@ApiOperation(value = "editar persons")
	@PutMapping(produces = {"application/json" , "application/xml", "application/x-yaml"}, 
		        consumes = {"application/json" , "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) {
		PersonVO personVo = service.update(person);
		personVo.add(linkTo(methodOn(PersonController.class).findById(personVo.getKey())).withSelfRel());
		return personVo;
	}	
	
	@ApiOperation(value = "desativar persons por id")
	@PatchMapping(value = "/{id}", produces = {"application/json" , "application/xml", "application/x-yaml"})
	public PersonVO disabledPerson(@PathVariable("id") Long id) {
		PersonVO personVo = service.disablePerson(id);
		personVo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVo;
	}	
	
	@ApiOperation(value = "deletar persons")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	

}