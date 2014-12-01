package modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Modalidade extends Entidade {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String nome;
	
	@OneToMany(mappedBy="modalidade")
	private List<AlunoModalidade> alunoModalidades;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public Serializable GetId() {
	return this.id;
	}
}
