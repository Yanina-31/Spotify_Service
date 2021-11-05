package com.spotify.spotify.service.controller;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.service.IArtistaService;
import com.spotify.spotify.service.types.model.Artista;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/artist")
public class ArtistaController {
    @Autowired
    private IArtistaService artistaService;


    @GetMapping(path = "/{artistId}")
    public Artista retriveArtista(@PathVariable  Long artistId){
        log.info("artistId {}", artistId);
        return this.artistaService.getArtista();
    }

    @GetMapping(path = "/artists/")
    public List<Artista> retriveArtistas() {
        return artistaService.getArtistas();
    }

    @PostMapping(path = "/artist")
//    public  Artista createArtista(@RequestBody ArtistaRequest request){
    public  Artista createArtista(@Validated @RequestBody ArtistaRequest request){
        return artistaService.createArtista(request);
    }
    /*@DeleteMapping(path = "/{artistId}")
    public Artista deleteArtista(@PathVariable Long idArtist){
        return this.artistaService.deleteArtista(idArtist);
    }
    @PutMapping(path = "/{artistId}")
    public Artista updateArtista(@PathVariable  Long idArtist){
        return this.artistaService.updateArtista(idArtist);
    }*/
}


