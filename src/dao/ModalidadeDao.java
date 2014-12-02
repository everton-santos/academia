package dao;

import java.util.List;

import javax.persistence.Query;

import modelos.Modalidade;

public class ModalidadeDao extends DaoGenerico<Modalidade> {

	@Override
	protected Class<Modalidade> getEntityClass() {
		return Modalidade.class;
	}

	public List<Modalidade> getListaPorNome(String nome) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(String.format(
				"select c from %s c where c.nome like UPPER(?)",
				Modalidade.class.getSimpleName()), Modalidade.class);

		query.setParameter(1, "%" + nome.toUpperCase() + "%");
		
		return query.getResultList();
	}

}
