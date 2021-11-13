package com.spotify.spotify.service.types.mapper;

import java.util.function.Function;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.stereotype.Component;
@Component
public class ArtistaMapper implements Function<ArtistaRequest, Artista> {
    @Override
    public Artista apply(ArtistaRequest artistaRequest) {
        return new Artista(artistaRequest.getIdArtist(),
                artistaRequest.getName(),
                artistaRequest.getGenre(),
                artistaRequest.getImage());
    }

}