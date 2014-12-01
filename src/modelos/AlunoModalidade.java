package modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AlunoModalidade extends Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date dataInscricao;
	@ManyToOne
	private Aluno aluno;

	@OneToMany(mappedBy = "alunoModalidade")
	private List<Ficha> fichas;
	
	@ManyToOne
	private Modalidade modalidade;
	
	

	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	@Override
	public Serializable GetId() {
		return this.id;
	}
}
