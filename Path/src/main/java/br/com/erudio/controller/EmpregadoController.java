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

import br.com.erudio.data.vo.v1.EmpregadoVO;
import br.com.erudio.services.EmpregadoServices;

@RestController
@RequestMapping("/api/empregado/v1")
public class EmpregadoController {

	@Autowired
	EmpregadoServices service;

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<EmpregadoVO> findAll() {
		List<EmpregadoVO> books = service.findAll();
		books.stream()
				.forEach(e -> e.add(linkTo(methodOn(EmpregadoController.class).findById(e.getKey())).withSelfRel()));
		return books;
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public EmpregadoVO findById(@PathVariable("id") Long id) {
		EmpregadoVO empregadoVo = service.findById(id);
		empregadoVo.add(linkTo(methodOn(EmpregadoController.class).findById(id)).withSelfRel());
		return empregadoVo;
	}

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public EmpregadoVO create(@RequestBody EmpregadoVO empregado) {
		EmpregadoVO empregadoVo = service.created(empregado);
		empregadoVo.add(linkTo(methodOn(EmpregadoController.class).findById(empregadoVo.getKey())).withSelfRel());
		return empregadoVo;
	}

	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public EmpregadoVO update(@RequestBody EmpregadoVO empregado) {
		EmpregadoVO empregadoVo = service.update(empregado);
		empregadoVo.add(linkTo(methodOn(EmpregadoController.class).findById(empregadoVo.getKey())).withSelfRel());
		return empregadoVo;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
