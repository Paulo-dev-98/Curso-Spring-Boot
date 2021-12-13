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

import br.com.erudio.data.vo.v1.CartaVO;
import br.com.erudio.services.CartaService;

@RestController
@RequestMapping("/api/carta/v1")
public class CartaController {

	@Autowired
	CartaService service;

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CartaVO> findAll() {
		List<CartaVO> cartas = service.findAll();
		cartas.stream().forEach(c -> c.add(linkTo(methodOn(CartaController.class).findById(c.getKey())).withSelfRel()));
		return cartas;
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public CartaVO findById(@PathVariable("id") Long id) {
		CartaVO cartaVo = service.findById(id);
		cartaVo.add(linkTo(methodOn(CartaController.class).findById(id)).withSelfRel());
		return cartaVo;
	}

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public CartaVO create(@RequestBody CartaVO carta) {
		CartaVO cartaVo = service.created(carta);
		cartaVo.add(linkTo(methodOn(CartaController.class).findById(cartaVo.getKey())).withSelfRel());
		return cartaVo;
	}

	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public CartaVO update(@RequestBody CartaVO carta) {
		CartaVO cartaVo = service.update(carta);
		cartaVo.add(linkTo(methodOn(CartaController.class).findById(cartaVo.getKey())).withSelfRel());
		return cartaVo;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
