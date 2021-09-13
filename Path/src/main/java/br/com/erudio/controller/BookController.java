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

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.services.BookServices;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {

	@Autowired
	BookServices service;

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<BookVO> findAll() {
		List<BookVO> books = service.findAll();
		books.stream().forEach(b -> b.add(linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel()));
		return books;
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public BookVO findById(@PathVariable("id") Long id) {
		BookVO bookVo = service.findById(id);
		bookVo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVo;
	}

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			     consumes = { "application/json", "application/xml", "application/x-yaml" })
	public BookVO create(@RequestBody BookVO book) {
		BookVO bookVo = service.created(book);
		bookVo.add(linkTo(methodOn(BookController.class).findById(bookVo.getKey())).withSelfRel());
		return bookVo;
	}
	
	@PutMapping(produces = {"application/json" , "application/xml", "application/x-yaml"}, 
	            consumes = {"application/json" , "application/xml", "application/x-yaml"})
    public BookVO update(@RequestBody BookVO book) {
	BookVO bookVo = service.update(book);
	bookVo.add(linkTo(methodOn(BookController.class).findById(bookVo.getKey())).withSelfRel());
	return bookVo;
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
