package dao;

import modelos.AlunoModalidade;

public class AlunoModalidadeDao  extends DaoGenerico<AlunoModalidade>{

	@Override
	protected Class<AlunoModalidade> getEntityClass() {
		return AlunoModalidade.class;
	}

}
