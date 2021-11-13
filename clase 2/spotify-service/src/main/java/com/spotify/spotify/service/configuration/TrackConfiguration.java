package com.spotify.spotify.service.configuration;


import com.spotify.spotify.service.types.model.Album;
import com.spotify.spotify.service.types.model.Artista;
import com.spotify.spotify.service.types.model.Track;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;
@Configuration
public class TrackConfiguration {
    @Bean(name = "tracks")
    public static List<Track> getTracks() {
        return Arrays.asList(new Track(1, "One", new Album(1, new Artista(1, "Metallica", "Rock", "image1"), "Death Magnetic"), 15, 4.02),
                new Track(2, "Revelations", new Album(2, new Artista(2, "Iron Maiden", "Rock", "image2"), "Iron Maiden"), 50, 4.25),
                new Track(3, "El Revelde", new Album(3, new Artista(3, "La Renga", "Rock", "image3"), "La esquina del infinito"), 75, 3.25),
                new Track(4, "En el Baldio", new Album(3, new Artista(3, "La Renga", "Rock", "image3"), "La esquina del infinito"), 70, 4),
                new Track(5, "Veneno", new Album(3, new Artista(3, "La Renga", "Rock", "image3"), "La esquina del infinito"), 95, 5.1),
                new Track(6, "O tu o ninguna", new Album(4, new Artista(4, "Luis Miguel", "Romantico", "image4"), "Romance"), 100, 4.20),
                new Track(7, "Si tu te atreves", new Album(4, new Artista(4, "Luis Miguel", "Romantico", "image4"), "Romance"), 115, 4.30),
                new Track(8, "Sabor a mi", new Album(4, new Artista(4, "Luis Miguel", "Romantico", "image4"), "Romance"), 101, 4.25),
                new Track(9, "Pasos de cero", new Album(5, new Artista(5, "Pablo Alboran", "Romantico", "image5"), "Prometo"), 120, 4.14),
                new Track(10, "Por fin", new Album(5, new Artista(5, "Pablo Alboran", "Romantico", "image5"), "Prometo"), 120, 4.23),
                new Track(11, "Recuerdame", new Album(5, new Artista(5, "Pablo Alboran", "Romantico", "image5"), "Prometo"), 150, 4),
                new Track(12, "Quien", new Album(5, new Artista(5, "Pablo Alboran", "Romantico", "image5"), "Prometo"), 125, 4.28),
                new Track(13, "La niña de la escuela", new Album(7, new Artista(7, "Tini Stoessel", "Pop", "image7"), "Quiero volver"), 151, 3.25),
                new Track(14, "Fresa", new Album(7, new Artista(7, "Tini Stoessel", "Pop", "image7"), "Quiero volver"), 150, 3.25),
                new Track(15, "Mienteme", new Album(7, new Artista(7, "Tini Stoessel", "Pop", "image7"), "Quiero volver"), 150, 3.25),
                new Track(16, "Que mas pues?", new Album(8, new Artista(8, "Maria Becerra", "Pop", "image8"), "Animal"), 155, 3.46),
                new Track(17, "Mi Debilidad", new Album(8, new Artista(8, "Maria Becerra", "Pop", "image8"), "Animal"), 120, 3.35),
                new Track(18, "Por primera vez", new Album(10, new Artista(10, "Camilo", "Pop latino", "image10"), "Por Primera vez"), 155, 3.16),
                new Track(19, "Vida de rico", new Album(10, new Artista(10, "Camilo", "Pop latino", "image10"), "Por Primera vez"), 150, 3.26),
                new Track(20, "Medialuna", new Album(10, new Artista(10, "Camilo", "Pop latino", "image10"), "Por Primera vez"), 169, 3));
    }
}
