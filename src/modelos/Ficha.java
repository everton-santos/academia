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
public class Ficha extends Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date data;
	private int periodo;
	
	@ManyToOne
	private Instrutor instrutor;
	
	@OneToMany(mappedBy = "ficha")
	private List<FichaExercicio> fichaExercicios;
	
	@ManyToOne
	private AlunoModalidade alunoModalidade;
	

	public List<FichaExercicio> getFichaExercicios() {
		return fichaExercicios;
	}

	public void setFichaExercicios(List<FichaExercicio> fichaExercicios) {
		this.fichaExercicios = fichaExercicios;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	@Override
	public Serializable GetId() {
		return this.id;
	}
}
