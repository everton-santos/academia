package modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlunoModalidade extends Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date dataInscricao;

	
	
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
