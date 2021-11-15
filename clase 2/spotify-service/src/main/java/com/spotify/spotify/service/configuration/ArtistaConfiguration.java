package com.spotify.spotify.service.configuration;

import com.spotify.spotify.service.types.model.Artista;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ArtistaConfiguration {
    @Bean(name = "artistas")
    public static List<Artista> getArtistas() {
        return Arrays.asList(
                Artista.builder()
                        .idArtist(1L)
                        .name("Metallica")
                        .genre("Rock")
                        .image("imagen1")
                        .build(),
                Artista.builder()
                        .idArtist(2L)
                        .name("Babasonicos")
                        .genre("Rock")
                        .image("imagen2")
                        .build(),
                Artista.builder()
                        .idArtist(3L)
                        .name("La Renga")
                        .genre("Rock")
                        .image("imagen3")
                        .build(),
                Artista.builder()
                        .idArtist(4L)
                        .name("Luis Miguel")
                        .genre("Romantico")
                        .image("imagen4")
                        .build(),
                Artista.builder()
                        .idArtist(5L)
                        .name("Pablo Alboran")
                        .genre("Romantico")
                        .image("imagen5")
                        .build(),
                Artista.builder()
                        .idArtist(6L)
                        .name("Chayanne")
                        .genre("Romantico")
                        .image("imagen6")
                        .build(),
                Artista.builder()
                        .idArtist(7L)
                        .name("Tini Stoessel")
                        .genre("Pop")
                        .image("imagen7")
                        .build(),
                Artista.builder()
                        .idArtist(8L)
                        .name("Maria Becerra")
                        .genre("Pop")
                        .image("imagen8")
                        .build(),
                Artista.builder()
                        .idArtist(9L)
                        .name("Nicki Nicole")
                        .genre("Hip-hop/rap")
                        .image("imagen9")
                        .build(),
                Artista.builder()
                        .idArtist(10L)
                        .name("Camilo")
                        .genre("Pop latino")
                        .image("imagen10")
                        .build());
    }
}

