package com.spotify.spotify.service.service;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.types.mapper.ArtistaMapper;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {
    public Artista getArtista(Long id) {
        return Artista.builder().idArtist(1L).genre("Rock").name("Babasonicos").image("nxnnxnnnnnnnnnnn").build();
    }
    @Autowired
    private ArtistaMapper artistaMapper;

    public Artista createArtista(ArtistaRequest request) {
        return artistaMapper.apply(request);
    }
}
