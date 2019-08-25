package br.com.anbima.backend.representation.dto;

public class SelicDTO implements ResourceDTO {
	
	private String data;
	private String taxa;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTaxa() {
		return taxa;
	}
	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}
}
