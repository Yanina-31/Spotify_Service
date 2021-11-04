package com.spotify.spotify.service.controller;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.service.ArtistaService;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/artist")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping(path = "/{artistId}")
    public Artista retriveArtista(@PathVariable  Long artistId){
        return this.artistaService.getArtista(artistId);
    }

    @PostMapping(path = "")
    public  Artista createArtista(@RequestBody ArtistaRequest request){
        return artistaService.createArtista(request);
    }
    @DeleteMapping(path = "/{artistId}")
    public Artista deleteArtista(@PathVariable Long artistId){
        return this.artistaService.deleteArtista(artistId);
    }
    @PutMapping(path = "/{artistId}")
    public Artista updateArtista(@PathVariable  Long artistId){
        return this.artistaService.updateArtista(artistId);
    }
}


