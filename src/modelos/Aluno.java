package modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Pessoa {

	@OneToMany(mappedBy = "aluno")
	private List<Avaliacao> avaliacoes;
	
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<AlunoModalidade> alunoModalidades;

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<AlunoModalidade> getAlunoModalidades() {
		return alunoModalidades;
	}

	public void setAlunoModalidades(List<AlunoModalidade> alunoModalidades) {
		this.alunoModalidades = alunoModalidades;
	}

}
