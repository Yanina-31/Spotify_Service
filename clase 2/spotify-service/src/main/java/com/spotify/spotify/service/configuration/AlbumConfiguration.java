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
        return Arrays.asList(new Album(1, new Artista(1, "Metallica", "Rock", "image1"), "Death Magnetic"),
                new Album(2, new Artista(2, "Iron Maiden", "Rock", "image2"), "Iron Maiden"),
                new Album(3, new Artista(3, "La Renga", "Rock", "image3"), "La esquina del infinito"),
                new Album(4, new Artista(4, "Luis Miguel", "Romantico", "image4"), "Romance"),
                new Album(5, new Artista(5, "Pablo Alboran", "Romantico", "image5"), "Prometo"),
                new Album(6, new Artista(6, "Chayanne", "Romantico", "image6"), "Provocame"),
                new Album(7, new Artista(7, "Tini Stoessel", "Pop", "image7"), "Quiero volver"),
                new Album(8, new Artista(8, "Maria Becerra", "Pop", "image8"), "Animal"),
                new Album(9, new Artista(9, "Nicki Nicole", "Hip-hop/rap", "image9"), "Recuerdos"),
                new Album(10, new Artista(10, "Camilo", "Pop latino", "image10"), "Por Primera vez"));
    }
}
