package br.com.fiap.exception;

public class EntityNotFoundException extends Exception {

	public EntityNotFoundException() {
		super("ERRO: Noi foi possivel enconctrar e entidade");
	}
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}
	
}