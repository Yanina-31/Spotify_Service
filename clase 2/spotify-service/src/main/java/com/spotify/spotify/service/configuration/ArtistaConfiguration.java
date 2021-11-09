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
                .name("Carla")
                .genre("Melodico")
                .image("kdnslmñm")
                .build(),
            Artista.builder()
                .name("Mauri")
                .genre("Rock")
                .image("kdnsljnñm")
                .build(),
            Artista.builder()
                .name("Facu")
                .genre("Infantil")
                .image("kdnsldcxxmñm")
                .build(),
            Artista.builder()
                .name("Rodrigo")
                .genre("Pop")
                .image("kdnslmcvvvvcñm")
                .build(),
            Artista.builder()
                .name("Mili")
                .genre("Pop")
                .image("vvvvcñm")
                .build());

    }
}
