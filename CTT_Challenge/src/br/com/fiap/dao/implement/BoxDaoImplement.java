package br.com.fiap.dao.implement;

import javax.persistence.EntityManager;
import br.com.fiap.dao.BoxDao;
import br.com.fiap.entidades.Box;

public class BoxDaoImplement extends GenericDaoImplement<Box, Integer> implements BoxDao {

	public BoxDaoImplement(EntityManager em) {
		super(em);
	}

}
