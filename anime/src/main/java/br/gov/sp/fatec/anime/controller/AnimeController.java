package br.gov.sp.fatec.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.anime.entity.Anime;
import br.gov.sp.fatec.anime.service.AnimeService;

@RestController
@RequestMapping(value = "/anime")
@CrossOrigin
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @PostMapping(value = "/novo")
    public Anime cadastrarAnime(@RequestBody AnimeDTO anime) {
        return animeService.adicionarAnime(anime.getUsuario(), 
        		anime.getAnimePersonagem(), 
        		anime.getAnimeNome());
    }

}