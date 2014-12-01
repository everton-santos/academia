package dao;

import modelos.Usuario;

public class UsuarioDao  extends DaoGenerico<Usuario>{

	@Override
	protected Class<Usuario> getEntityClass() {
		return Usuario.class;
	}
	
}
