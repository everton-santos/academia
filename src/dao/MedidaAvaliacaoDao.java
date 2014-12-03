package dao;

import modelos.MedidaAvaliacao;

public class MedidaAvaliacaoDao extends DaoGenerico<MedidaAvaliacao> {

	@Override
	protected Class<MedidaAvaliacao> getEntityClass() {
		return MedidaAvaliacao.class;
	}

}
