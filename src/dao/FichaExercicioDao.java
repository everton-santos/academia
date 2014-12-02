package dao;

import modelos.FichaExercicio;

public class FichaExercicioDao extends DaoGenerico<FichaExercicio> {

	@Override
	protected Class<FichaExercicio> getEntityClass() {
		return FichaExercicio.class;
	}

}
