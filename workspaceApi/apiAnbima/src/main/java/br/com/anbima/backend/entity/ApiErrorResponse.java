package br.com.anbima.backend.entity;

public class ApiErrorResponse {
	
	private String mensagem;

	public ApiErrorResponse(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
}
