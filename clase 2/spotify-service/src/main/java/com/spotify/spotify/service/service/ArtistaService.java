package com.spotify.spotify.service.service;

import com.spotify.spotify.service.types.model.Artista;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {
    public Artista getArtista(Long id) {
        return Artista.builder().idArtist(1L).genre("Rock").name("Babasonicos").image("nxnnxnnnnnnnnnnn").build();
    }
}
