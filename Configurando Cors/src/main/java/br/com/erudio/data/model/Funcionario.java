package br.com.erudio.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private int matricula;
	
	@Column
	private String funçãoPrincipal;
	
	@Column
	private String tituloDoFuncionario;
	
	public Funcionario() {
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getFunçãoPrincipal() {
		return funçãoPrincipal;
	}

	public void setFunçãoPrincipal(String funçãoPrincipal) {
		this.funçãoPrincipal = funçãoPrincipal;
	}

	public String getTituloDoFuncionario() {
		return tituloDoFuncionario;
	}

	public void setTituloDoFuncionario(String tituloDoFuncionario) {
		this.tituloDoFuncionario = tituloDoFuncionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funçãoPrincipal == null) ? 0 : funçãoPrincipal.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + matricula;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tituloDoFuncionario == null) ? 0 : tituloDoFuncionario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (funçãoPrincipal == null) {
			if (other.funçãoPrincipal != null)
				return false;
		} else if (!funçãoPrincipal.equals(other.funçãoPrincipal))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricula != other.matricula)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tituloDoFuncionario == null) {
			if (other.tituloDoFuncionario != null)
				return false;
		} else if (!tituloDoFuncionario.equals(other.tituloDoFuncionario))
			return false;
		return true;
	}
	
	
	
}
