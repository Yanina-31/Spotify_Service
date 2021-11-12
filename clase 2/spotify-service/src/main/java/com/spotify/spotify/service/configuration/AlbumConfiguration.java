package com.spotify.spotify.service.configuration;
import com.spotify.spotify.service.types.model.Album;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AlbumConfiguration {
    @Bean(name = "albums")
    public static List<Album> getAlbums(){
        return Arrays.asList(
                Album.builder()
                        .idArtist(1L)
                        .name("Romances")
                        .build(),
                Album.builder()
                        .idArtist(2L)
                        .name("Detonador de Sueños")
                        .build(),
                Album.builder()
                        .idArtist(3L)
                        .name("La esquina del infinito")
                        .build(),
                Album.builder()
                        .idArtist(4L)
                        .name("Prometo")
                        .build(),
                Album.builder()
                        .idArtist(5L)
                        .name("Infame")
                        .build());
    }
}
