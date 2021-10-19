package br.com.fiap.dao.implement;

import javax.persistence.EntityManager;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entidades.Usuario;

public class UsuarioDaoImplement extends GenericDaoImplement<Usuario, Integer> implements UsuarioDao {

	public UsuarioDaoImplement(EntityManager em) {
		super(em);
	}

}