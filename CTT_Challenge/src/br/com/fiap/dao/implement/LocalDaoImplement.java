package br.com.fiap.dao.implement;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LocalDao;
import br.com.fiap.entidades.Local;

public class LocalDaoImplement extends GenericDaoImplement<Local, Integer> implements LocalDao {

	public LocalDaoImplement(EntityManager em) {
		super(em);
	}

}
