package dao;

import modelos.Avaliacao;

public class AvaliacaoDao extends DaoGenerico<Avaliacao> {

	@Override
	protected Class<Avaliacao> getEntityClass() {
		return Avaliacao.class;
	}
	
}
