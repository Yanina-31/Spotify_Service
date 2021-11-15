package com.spotify.spotify.service.configuration;

import com.spotify.spotify.service.types.model.Album;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;
@Configuration
public class AlbumConfiguration {
    @Bean(name = "albums")
    public static List<Album> getAlbums() {
        return Arrays.asList(
                Album.builder()
                        .idAlbum(1L)
                        .idArtist(new Artista(1L, "Metallica", "Rock", "image1"))
                        .name("Death Magnetic")
                        .build(),
                Album.builder()
                        .idAlbum(2L)
                        .idArtist(new Artista(2L, "Babasonicos", "Rock", "image2"))
                        .name("Infame")
                        .build(),
                Album.builder()
                        .idAlbum(3L)
                        .idArtist(new Artista(3L, "La Renga", "Rock", "image3"))
                        .name("La esquina del infinito")
                        .build(),
                Album.builder()
                        .idAlbum(4L)
                        .idArtist(new Artista(4L, "Luis Miguel", "Romantico", "image4"))
                        .name("Romance")
                        .build(),
                Album.builder()
                        .idAlbum(5L)
                        .idArtist(new Artista(5L, "Pablo Alboran", "Romantico", "image5"))
                        .name("Prometo")
                        .build(),
                Album.builder()
                        .idAlbum(6L)
                        .idArtist(new Artista(6L, "Chayanne", "Romantico", "image6"))
                        .name("Provocame")
                        .build(),
                Album.builder()
                        .idAlbum(7L)
                        .idArtist(new Artista(7L, "Tini Stoessel", "Pop", "image7"))
                        .name("Quiero volver")
                        .build(),
                Album.builder()
                        .idAlbum(8L)
                        .idArtist(new Artista(8L, "Maria Becerra", "Pop", "image8"))
                        .name("Animal")
                        .build(),
                Album.builder()
                        .idAlbum(9L)
                        .idArtist(new Artista(9L, "Nicki Nicole", "Hip-hop/rap", "image9"))
                        .name("Recuerdos")
                        .build(),
                Album.builder()
                        .idAlbum(10L)
                        .idArtist(new Artista(10L, "Camilo", "Pop latino", "image10"))
                        .name("Por Primera vez")
                        .build());
    }
}
