package com.spotify.spotify.service.configuration;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ArtistaConfiguration {

    @Bean (name = "artistas")
    public static List<Artista> getArtistas(){
        return Arrays.asList(
            Artista.builder()
                .idArtist(1L)
                .name("Carla")
                .genre("Melodico")
                .image("kdnslmñm")
                .build(),
            Artista.builder()
                .idArtist(2L)
                .name("Mauri")
                .genre("Rock")
                .image("kdnsljnñm")
                .build(),
            Artista.builder()
                .idArtist(3L)
                .name("Facu")
                .genre("Infantil")
                .image("kdnsldcxxmñm")
                .build(),
            Artista.builder()
                .idArtist(4L)
                .name("Rodrigo")
                .genre("Pop")
                .image("kdnslmcvvvvcñm")
                .build(),
            Artista.builder()
                .idArtist(5L)
                .name("Mili")
                .genre("Pop")
                .image("vvvvcñm")
                .build());

    }
}
