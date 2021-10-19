package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Gerenciar a única instância da fabrica - EntityManagerFactory 
 *
 */
public class EMFS {

	//Armazena um unica instancia 
	private static EntityManagerFactory fabrica;
	
	
	//Aqui retorna uma unica instancia
	public static EntityManagerFactory getInstance() {
		
		//Aqui valida a instanciacao da fabrica 
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
	//Esse aqui é o construtor privado
	private EMFS() {}
	
}