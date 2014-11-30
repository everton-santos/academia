package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelos.Entidade;

public abstract class DaoGenerico<T extends Entidade > {
	protected static EntityManagerFactory entityManagerFactory;
	protected EntityManager manager;

	public DaoGenerico() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("academia");
		}
	}

	protected abstract Class<T> getEntityClass();

	public void salvar(T obj) {

		T retorno = null;
		try {
			retorno = consultarPorID(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (retorno != null) {
			alterar(obj);
		} else {
			incluir(obj);
		}
	}

	protected void incluir(T obj) {
		manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
		// manager.close();
	}

	public void remover(T obj) {
		manager = entityManagerFactory.createEntityManager();
		@SuppressWarnings("unchecked")
		T pObj = (T) manager.find(obj.getClass(), obj.GetId());
		manager.getTransaction().begin();
		manager.remove(pObj);
		manager.getTransaction().commit();
		// manager.close();
	}

	@SuppressWarnings("unchecked")
	public T consultarPorID(T obj) {

		T result = null;

		manager = entityManagerFactory.createEntityManager();

		Serializable id = obj.GetId();

		try {
			if (id != null) {
				result = (T) manager.find(obj.getClass(), id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// manager.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(T obj) {
		manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery(String.format("select c from %s c",
				obj.getClass().getSimpleName()), obj.getClass());
		return query.getResultList();
	}

	protected void alterar(T obj) {
		manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(obj);
		manager.getTransaction().commit();
		// manager.close();
	}
}
