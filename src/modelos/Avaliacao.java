package modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avaliacao extends Entidade {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private Date data;
	
	

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
