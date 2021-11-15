package com.spotify.spotify.service.types.mapper;

import java.util.function.Function;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.stereotype.Component;

@Component
public class ArtistaMapper implements Function<ArtistaRequest, Artista> {
    @Override
    public Artista apply(ArtistaRequest artistRequest) {
        return Artista.builder()
                .idArtist(artistRequest.getIdArtist())
                .name(artistRequest.getName())
                .genre(artistRequest.getGenre())
                .image(artistRequest.getImage())
                .build();
    }
}