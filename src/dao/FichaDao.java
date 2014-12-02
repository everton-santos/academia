package dao;

import modelos.Ficha;

public class FichaDao extends DaoGenerico<Ficha>
{

	@Override
	protected Class<Ficha> getEntityClass() {
		return Ficha.class;
	}
	
}
