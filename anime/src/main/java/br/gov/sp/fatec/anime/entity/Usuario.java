package br.gov.sp.fatec.anime.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "usr_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name = "usr_id")
	private Long id;
	
	@Column (name = "usr_nome", unique=true, length = 20, nullable = false)
	private String nome;
	
	@Column (name = "usr_email", unique=true, length = 100, nullable = false)
	private String email;
	
	@Column(name = "usr_senha", unique=true, length = 100, nullable = false)
	private String senha;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable (name = "uau_usuario_autorizacao",
		joinColumns = { @JoinColumn(name = "usr_id") },
		inverseJoinColumns = { @JoinColumn(name = "aut_id") })
	private Set<Autorizacao> autorizacoes;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "charUsr")
	private Set<Anime> animes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public Set<Anime> getAnimes() {
		return animes;
	}
	
	public void setAnimes(Set<Anime> animes) {
		this.animes = animes;
	}
	
}
