package dao;

import java.util.List;

import javax.persistence.Query;

import modelos.Medicao;

public class MedicaoDao extends DaoGenerico<Medicao> {

	@Override
	protected Class<Medicao> getEntityClass() {
		return Medicao.class;
	}
	public List<Medicao> getListaPorNome(String nome) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(String.format(
				"select c from %s c where c.descricao like UPPER(?)",
				Medicao.class.getSimpleName()), Medicao.class);

		query.setParameter(1, "%" + nome.toUpperCase() + "%");
		
		return query.getResultList();
	}
	
}
