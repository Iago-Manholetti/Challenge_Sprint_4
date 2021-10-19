package br.com.fiap.dao.implement;

import javax.persistence.EntityManager;
import br.com.fiap.dao.HistoricoDao;
import br.com.fiap.entidades.Historico;

public class HistoricoDaoImplement extends GenericDaoImplement<Historico, Integer> implements HistoricoDao {

	public HistoricoDaoImplement(EntityManager em) {
		super(em);
	}

}
