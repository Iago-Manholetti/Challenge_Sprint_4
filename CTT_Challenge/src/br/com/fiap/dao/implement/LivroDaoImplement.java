package br.com.fiap.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.dao.LivroDao;
import br.com.fiap.entidades.Livro;

public class LivroDaoImplement extends GenericDaoImplement<Livro, Integer> implements LivroDao {

	public LivroDaoImplement(EntityManager em) {
		super(em);
	}

	@Override
	public List<Livro> buscarTitulo(String titulo) {
		return em.createQuery("from Livro c where upper(c.titulo) like upper(:pTitulo)", Livro.class)
				.setParameter("pTitulo", "%" + titulo + "%")
				.getResultList();
	}
	
}
