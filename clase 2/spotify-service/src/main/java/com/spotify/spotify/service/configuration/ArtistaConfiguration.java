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
                        .name("Carla")
                        .genre("Melodico")
                        .image("imagen1")
                        .build(),
                Artista.builder()
                        .name("Mauri")
                        .genre("Rock")
                        .image("imagen2")
                        .build(),
                Artista.builder()
                        .name("Facu")
                        .genre("Infantil")
                        .image("imagen3")
                        .build(),
                Artista.builder()
                        .name("Rodrigo")
                        .genre("Electronica")
                        .image("imagen4")
                        .build(),
                Artista.builder()
                        .name("Mili")
                        .genre("Pop")
                        .image("imagen5")
                        .build());
    }
}
