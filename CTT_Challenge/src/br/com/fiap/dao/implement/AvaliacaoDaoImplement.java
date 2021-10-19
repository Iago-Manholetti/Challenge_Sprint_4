package br.com.fiap.dao.implement;

import javax.persistence.EntityManager;
import br.com.fiap.dao.AvaliacaoDao;
import br.com.fiap.entidades.Avaliacao;

public class AvaliacaoDaoImplement extends GenericDaoImplement<Avaliacao, Integer> implements AvaliacaoDao {

	public AvaliacaoDaoImplement(EntityManager em) {
		super(em);
	}

}
