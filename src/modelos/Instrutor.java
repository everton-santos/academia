package modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Instrutor extends Pessoa {
	
	@OneToMany(mappedBy = "instrutor")
	private List<MedidaAvaliacao> medidasAvaliacao;
	
	@OneToMany(mappedBy = "instrutor")
	private List<Ficha> fichas;
	
	public List<MedidaAvaliacao> getMedidasAvaliacao() {
		return medidasAvaliacao;
	}

	public void setMedidasAvaliacao(List<MedidaAvaliacao> medidasAvaliacao) {
		this.medidasAvaliacao = medidasAvaliacao;
	}

	public List<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}
	
	
}
