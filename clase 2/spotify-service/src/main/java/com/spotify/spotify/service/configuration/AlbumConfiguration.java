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
                        .idAlbum(1L)
                        .idArtist(1L)
                        .name("La felicidad")
                        .build(),
                Album.builder()
                        .idAlbum(2L)
                        .idArtist(2L)
                        .name("Me gusta Java")
                        .build(),
                Album.builder()
                        .idAlbum(3L)
                        .idArtist(3L)
                        .name("Quiero aprender mas")
                        .build(),
                Album.builder()
                        .idAlbum(4L)
                        .idArtist(4L)
                        .name("Cuando calienta el sol")
                        .build(),
                Album.builder()
                        .idAlbum(5L)
                        .idArtist(5L)
                        .name("Aqui em la playa")
                        .build());
    }
}
