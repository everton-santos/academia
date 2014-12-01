package dao;

import modelos.Aluno;

public class AlunoDao extends DaoGenerico<Aluno> {

	@Override
	protected Class<Aluno> getEntityClass() {
		return Aluno.class;
	}
}
