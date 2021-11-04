package com.spotify.spotify.service.service;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.types.mapper.ArtistaMapper;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {
    public Artista getArtista(Long artistId) {
        return Artista.builder()
                .idArtist(1L)
                .name("Babasonicos")
                .genre("Rock")
                .image("nxnnxnnnnnnnnnnn")
                .build();
    }
    @Autowired
    private ArtistaMapper artistaMapper;

    public Artista createArtista(ArtistaRequest request) {
        return artistaMapper.apply(request);
    }

    public Artista deleteArtista(Long artistId) {
        return Artista.builder()
                //.idArtist(artistId)
                //.name("null-null")
                //.genre("null-null")
                //.image("null-null")
                .build();

    }

    public Artista updateArtista(Long artistId) {
        return Artista.builder()
                .idArtist(artistId)
                .name("La Renga")
                .genre("Romantic")
                .image("ljedkjjuygvbn")
                .build();
    }
}
