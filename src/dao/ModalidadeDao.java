package dao;

import modelos.Modalidade;

public class ModalidadeDao extends DaoGenerico<Modalidade> {

	@Override
	protected Class<Modalidade> getEntityClass() {
		return Modalidade.class;
	}

}
