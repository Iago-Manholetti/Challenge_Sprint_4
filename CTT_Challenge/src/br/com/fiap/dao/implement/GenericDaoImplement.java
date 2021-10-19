package br.com.fiap.dao.implement;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public abstract class GenericDaoImplement<A,B> implements GenericDao<A,B>{

	protected EntityManager em;
	
	private Class<A> clazz; //O .class da entidade
	
	@SuppressWarnings("all")
	public GenericDaoImplement(EntityManager em) {
		this.em = em;
		this.clazz = (Class<A>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void insert(A entidade) {
		em.persist(entidade);
	}

	@Override
	public A findById(B id) throws EntityNotFoundException {
		A entidade = em.find(clazz, id);
		if (entidade == null)
			throw new EntityNotFoundException();
		return entidade;
	}

	@Override
	public void update(A entidade) {
		em.merge(entidade);
	}

	@Override
	public void delete(B id) throws EntityNotFoundException {
		A entidade = findById(id);
		em.remove(entidade);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
	
	@Override
	public List<A> listar() {
		TypedQuery<A> query = em.createQuery("from " + clazz.getName(), clazz);
		query.setMaxResults(20); //Configura o máximo de resultados que serão retornados
		return query.getResultList();
	}
	
}
