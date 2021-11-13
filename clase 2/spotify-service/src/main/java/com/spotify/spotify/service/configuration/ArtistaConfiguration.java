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
        return Arrays.asList(new Artista(1, "Metallica", "Rock", "image1"),
                new Artista(2, "Iron Maiden", "Rock", "image2"),
                new Artista(3, "La Renga", "Rock", "image3"),
                new Artista(4, "Luis Miguel", "Romantico", "image4"),
                new Artista(5, "Pablo Alboran", "Romantico", "image5"),
                new Artista(6, "Chayanne", "Romantico", "image6"),
                new Artista(7, "Tini Stoessel", "Pop", "image7"),
                new Artista(8, "Maria Becerra", "Pop", "image8"),
                new Artista(9, "Nicki Nicole", "Hip-hop/rap", "image9"),
                new Artista(10, "Camilo", "Pop latino", "image10"));
    }
}
