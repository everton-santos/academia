package dao;

import java.util.List;

import javax.persistence.Query;

import modelos.Aluno;
import modelos.Instrutor;

public class InstrutorDao extends DaoGenerico<Instrutor> {

	@Override
	protected Class<Instrutor> getEntityClass() {
		return Instrutor.class;
	}

	public List<Instrutor> getListaPorNome(String nome) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(String.format(
				"select c from %s c where c.nome like UPPER(?)",
				Instrutor.class.getSimpleName()), Instrutor.class);

		query.setParameter(1, "%" + nome.toUpperCase() + "%");

		return query.getResultList();
	}
	
	public List<Instrutor> getListaPorNomeModalidade(String nome, int idModalidade) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(String.format(
				"select c from %s c INNER JOIN c.alunoModalidades c2 where c.nome like UPPER(?) and c2.modalidade.id = ?",
				Instrutor.class.getSimpleName()), Instrutor.class);

		query.setParameter(1, nome.toUpperCase());
		query.setParameter(2, idModalidade);
		
		return query.getResultList();
	}

}
