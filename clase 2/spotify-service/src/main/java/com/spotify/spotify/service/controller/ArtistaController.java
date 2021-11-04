package com.spotify.spotify.service.controller;

import com.spotify.spotify.service.service.ArtistaService;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/artista")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping(path = "/{id}")
    public Artista retrivePinnaper(@PathVariable  Long id) {
        //log.info("id {}", id);
        return this.artistaService.getArtista(id);
    }
}
