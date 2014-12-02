package dao;

import java.util.List;

import javax.persistence.Query;

import modelos.Exercicio;
import modelos.Modalidade;

public class ExercicioDao extends DaoGenerico<Exercicio> {

	@Override
	protected Class<Exercicio> getEntityClass() {
		return Exercicio.class;
	}

	public List<Exercicio> getListaPorNome(String nome) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(String.format(
				"select c from %s c where c.nome like UPPER(?)",
				Exercicio.class.getSimpleName()), Exercicio.class);

		query.setParameter(1, "%" + nome.toUpperCase() + "%");
		
		return query.getResultList();
	}
	

}
