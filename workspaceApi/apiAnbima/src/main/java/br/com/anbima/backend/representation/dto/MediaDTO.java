package br.com.anbima.backend.representation.dto;

public class MediaDTO implements ResourceDTO {
	
	private Integer ano;
	private Double media;
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
		this.media = media;
	}
}
