package modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FichaExercicio extends Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int qtdRepeticoes;
	private int qtdSeries;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdRepeticoes() {
		return qtdRepeticoes;
	}

	public void setQtdRepeticoes(int qtdRepeticoes) {
		this.qtdRepeticoes = qtdRepeticoes;
	}

	public int getQtdSeries() {
		return qtdSeries;
	}

	public void setQtdSeries(int qtdSeries) {
		this.qtdSeries = qtdSeries;
	}

	@Override
	public Serializable GetId() {
		return this.id;
	}
}