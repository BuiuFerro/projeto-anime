package br.gov.sp.fatec.anime.controller;

import java.util.Date;

public class AnimeDTO {

	private Long animeId;

	private String usuario;

	private String animePersonagem;

	private String animeNome;

	private Date animeAno;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAnimePersonagem() {
		return animePersonagem;
	}

	public void setAnimePersonagem(String animePersonagem) {
		this.animePersonagem = animePersonagem;
	}

	public String getAnimeNome() {
		return animeNome;
	}

	public void setAnimeNome(String animeNome) {
		this.animeNome = animeNome;
	}

	public Date getAnimeAno() {
		return animeAno;
	}

	public void setAnimeAno(Date animeAno) {
		this.animeAno = animeAno;
	}

	public Long getAnimeId() {
		return animeId;
	}

	public void setId(Long animeId) {
		this.animeId = animeId;
	}
}
