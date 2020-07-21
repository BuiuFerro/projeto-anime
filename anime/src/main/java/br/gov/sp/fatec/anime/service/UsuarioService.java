package br.gov.sp.fatec.anime.service;

import br.gov.sp.fatec.anime.entity.Usuario;

public interface UsuarioService {

    public Usuario novoUsuario (String nome, String email, String senha, String nomeAutorizacao);
}