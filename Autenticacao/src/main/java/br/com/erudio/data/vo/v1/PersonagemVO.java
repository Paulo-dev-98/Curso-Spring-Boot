package br.com.erudio.data.vo.v1;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.hateoas.ResourceSupport;

import com.github.dozermapper.core.Mapping;

public class PersonagemVO extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	private Long key;
	
	@Column
	private String Nome;
	
	@Column
	private int idade;
	
	@Column
	private String sexo;
	
	@Column
	private String origem;
	
	@Column
	private String universo;
	
	@Column
	private String habitacao;
	
	@Column
	private String personalidade;
	
	@Column
	private String poder;
	
	@Column(name="frase_de_efeito_numero_1")
	private String fraseDeEfeitoNumero1;
	
	@Column(name="frase_de_efeito_numero_2")
	private String fraseDeEfeitoNumero2;
	

	public PersonagemVO() {
		
		
	}


	public Long getKey() {
		return key;
	}


	public void setKey(Long key) {
		this.key = key;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getUniverso() {
		return universo;
	}


	public void setUniverso(String universo) {
		this.universo = universo;
	}


	public String getHabitação() {
		return habitacao;
	}


	public void setHabitação(String habitação) {
		this.habitacao = habitação;
	}


	public String getPersonalidade() {
		return personalidade;
	}


	public void setPersonalidade(String personalidade) {
		this.personalidade = personalidade;
	}


	public String getPoder() {
		return poder;
	}


	public void setPoder(String poder) {
		this.poder = poder;
	}


	public String getFraseDeEfeitoNumero1() {
		return fraseDeEfeitoNumero1;
	}


	public void setFraseDeEfeitoNumero1(String fraseDeEfeitoNumero1) {
		this.fraseDeEfeitoNumero1 = fraseDeEfeitoNumero1;
	}


	public String getFraseDeEfeitoNumero2() {
		return fraseDeEfeitoNumero2;
	}


	public void setFraseDeEfeitoNumero2(String fraseDeEfeitoNumero2) {
		this.fraseDeEfeitoNumero2 = fraseDeEfeitoNumero2;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((fraseDeEfeitoNumero1 == null) ? 0 : fraseDeEfeitoNumero1.hashCode());
		result = prime * result + ((fraseDeEfeitoNumero2 == null) ? 0 : fraseDeEfeitoNumero2.hashCode());
		result = prime * result + ((habitacao == null) ? 0 : habitacao.hashCode());
		result = prime * result + idade;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + ((personalidade == null) ? 0 : personalidade.hashCode());
		result = prime * result + ((poder == null) ? 0 : poder.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((universo == null) ? 0 : universo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonagemVO other = (PersonagemVO) obj;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (fraseDeEfeitoNumero1 == null) {
			if (other.fraseDeEfeitoNumero1 != null)
				return false;
		} else if (!fraseDeEfeitoNumero1.equals(other.fraseDeEfeitoNumero1))
			return false;
		if (fraseDeEfeitoNumero2 == null) {
			if (other.fraseDeEfeitoNumero2 != null)
				return false;
		} else if (!fraseDeEfeitoNumero2.equals(other.fraseDeEfeitoNumero2))
			return false;
		if (habitacao == null) {
			if (other.habitacao != null)
				return false;
		} else if (!habitacao.equals(other.habitacao))
			return false;
		if (idade != other.idade)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (personalidade == null) {
			if (other.personalidade != null)
				return false;
		} else if (!personalidade.equals(other.personalidade))
			return false;
		if (poder == null) {
			if (other.poder != null)
				return false;
		} else if (!poder.equals(other.poder))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (universo == null) {
			if (other.universo != null)
				return false;
		} else if (!universo.equals(other.universo))
			return false;
		return true;
	}
	
	

}
