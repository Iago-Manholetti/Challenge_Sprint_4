package br.com.fiap.exception;

public class CommitException extends Exception {

	public CommitException() {
		super("ERRO: Nao foi possivel fazer o commit");
	}
	
	public CommitException(String msg) {
		super(msg);
	}
	
}