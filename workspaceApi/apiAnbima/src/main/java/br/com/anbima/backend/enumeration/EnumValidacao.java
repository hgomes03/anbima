package br.com.anbima.backend.enumeration;

public enum EnumValidacao {
	
	SELIC_NAO_ENCONTRADA(1l, "Nenhuma Selic Encontrada !"),
	ANO_INVALIDO(2l, "Ano invalido !"),
	MES_INVALIDO(3l, "Mes invalid !");
	
	private Long codigo;
	
	private String mensagem;
	
	private EnumValidacao(Long codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getMensagem() {
		return mensagem;
	}
}
