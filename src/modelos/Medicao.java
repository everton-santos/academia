package modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medicao extends Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date data;

	@OneToMany(mappedBy = "medicao")
	private List<MedidaAvaliacao> medidasAvaliacao;

	public List<MedidaAvaliacao> getMedidasAvaliacao() {
		return medidasAvaliacao;
	}

	public void setMedidasAvaliacao(List<MedidaAvaliacao> medidasAvaliacao) {
		this.medidasAvaliacao = medidasAvaliacao;
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

	@Override
	public Serializable GetId() {
		return this.id;
	}
}
