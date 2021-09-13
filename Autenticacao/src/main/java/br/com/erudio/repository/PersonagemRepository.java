package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.data.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

}
