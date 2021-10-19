package br.com.fiap.dao.implement;

import javax.persistence.EntityManager;
import br.com.fiap.dao.CategoriaDao;
import br.com.fiap.entidades.Categoria;

public class CategoriaDaoImplement extends GenericDaoImplement<Categoria, Integer> implements CategoriaDao {

	public CategoriaDaoImplement(EntityManager em) {
		super(em);
	}

}
