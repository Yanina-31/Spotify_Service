package com.spotify.spotify.service.service.impl;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.service.IArtistaService;
import com.spotify.spotify.service.types.mapper.ArtistaMapper;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService implements IArtistaService {

    @Autowired
    private ArtistaMapper artistaMapper;

    @Qualifier("artistas")
    @Autowired
    private List<Artista> artistas;


    @Override
    public Artista getArtista() {
        return Artista.builder()
                .idArtist(1L)
                .name("Babasonicos")
                .genre("Rock")
                .image("nxnnxnnnnnnnnnnn")
                .build();
    }

    @Override
    public List<Artista> getArtistas(){
        return artistas;
    }

    @Override
    public Artista createArtista(ArtistaRequest request) {
        return artistaMapper.apply(request);
    }

    /*public Artista deleteArtista(Long artistId) {
        return Artista.builder()
                //.idArtist(artistId)
                //.name("null-null")
                //.genre("null-null")
                //.image("null-null")
                .build();

    }

    public Artista updateArtista(Long idArtist) {
        return Artista.builder()
                .idArtist(idArtist)
                .name("La Renga")
                .genre("Romantic")
                .image("ljedkjjuygvbn")
                .build();
    }*/
}
