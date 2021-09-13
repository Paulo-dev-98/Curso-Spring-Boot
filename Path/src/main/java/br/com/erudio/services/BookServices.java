package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Book;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.BookRepository;

@Service
public class BookServices {
	
	@Autowired
	BookRepository repository;
	
	public BookVO created(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity),BookVO.class);
		return vo;
	}
	
	public List<BookVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class) ;
	}
	
	public BookVO findById(Long id) {
		
		var entity =  repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		entity.setAutor(book.getAutor());
		entity.setLancamento(book.getLancamento());
		entity.setPreco(book.getPreco());
		entity.setTitulo(book.getTitulo());
		var vo = DozerConverter.parseObject(repository.save(entity),BookVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Book entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		repository.delete(entity);
		
	}

}
