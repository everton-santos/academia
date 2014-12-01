package dao;

import java.util.List;

import javax.persistence.Query;

import modelos.Aluno;

public class AlunoDao extends DaoGenerico<Aluno> {

	@Override
	protected Class<Aluno> getEntityClass() {
		return Aluno.class;
	}

	public List<Aluno> getListaPorNome(String nome) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(String.format(
				"select c from %s c where c.nome like UPPER(?)",
				Aluno.class.getSimpleName()), Aluno.class);

		query.setParameter(1, "%" + nome.toUpperCase() + "%");
		
		return query.getResultList();
	}

	public List<Aluno> getListaPorNomeModalidade(String nome, int idModalidade) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(String.format(
				"select c from %s c INNER JOIN c.alunoModalidades c2 where c.nome like UPPER(?) and c2.modalidade.id = ?",
				Aluno.class.getSimpleName()), Aluno.class);

		query.setParameter(1, nome.toUpperCase());
		query.setParameter(2, idModalidade);
		
		return query.getResultList();
	}
	
}
