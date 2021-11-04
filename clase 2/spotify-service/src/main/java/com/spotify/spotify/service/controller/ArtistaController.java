package com.spotify.spotify.service.controller;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.service.ArtistaService;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/artista")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping(path = "/{id}")
    public Artista retrivePinnaper(@PathVariable  Long id){
        return this.artistaService.getArtista(id);
    }

    @PostMapping(path = "")
    public  Artista creatArtista(@RequestBody ArtistaRequest request){
        return artistaService.createArtista(request);
    }
}


