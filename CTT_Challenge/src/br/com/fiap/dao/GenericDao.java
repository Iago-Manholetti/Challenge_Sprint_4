package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public interface GenericDao<A, B> {
	
	void insert(A entidade);
	
	A findById(B id) throws EntityNotFoundException;
	
	void update(A entidade);
	
	void delete(B id) throws EntityNotFoundException;
	
	void commit() throws CommitException;
	
	List<A> listar();

}
