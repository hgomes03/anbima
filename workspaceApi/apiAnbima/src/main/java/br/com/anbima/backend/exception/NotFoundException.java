package br.com.anbima.backend.exception;

public class NotFoundException extends Exception {
	public NotFoundException(String mensagem) {
		super(mensagem);
	}
}
