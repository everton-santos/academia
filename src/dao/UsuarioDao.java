package dao;

import javax.persistence.Query;

import modelos.Usuario;

public class UsuarioDao extends DaoGenerico<Usuario> {

	@Override
	protected Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

	public Usuario autentica(String login, String senha) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(String.format(
				"select c from %s c where c.login = ? and c.senha = ?",
				Usuario.class.getSimpleName()), Usuario.class);

		query.setParameter(1, login);
		query.setParameter(2, senha);

		Usuario user = (Usuario) query.getSingleResult();
		return user;
	}

}
