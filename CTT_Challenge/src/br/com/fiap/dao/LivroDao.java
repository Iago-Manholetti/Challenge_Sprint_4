package br.com.fiap.dao;

import java.util.List;


import br.com.fiap.entidades.Livro;

public interface LivroDao  extends GenericDao<Livro, Integer>{

	List<Livro> buscarTitulo(String titulo);

}
