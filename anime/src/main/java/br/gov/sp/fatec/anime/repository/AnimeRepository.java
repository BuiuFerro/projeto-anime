package br.gov.sp.fatec.anime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.anime.entity.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    public List<Anime> findByCharUsrNomeOrCharUsrEmail (String nome, String email);

}
