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
        return Arrays.asList(
                Track.builder()
                        .id(1L)
                        .name("One")
                        .idAlbum(new Album(1L, new Artista(1L, "Metallica", "Rock", "image1"), "Death Magnetic"))
                        .reproduction(15L)
                        .duration(3.23)
                        .build(),
                Track.builder()
                        .id(2L)
                        .name("Irresponsables")
                        .idAlbum(new Album(2L, new Artista(2L, "Iron Maiden", "Rock", "image2"), "Iron Maiden"))
                        .reproduction(252L)
                        .duration(3.20)
                        .build(),
                Track.builder()
                        .id(3L)
                        .name("El Revelde")
                        .idAlbum(new Album(3L, new Artista(3L, "La Renga", "Rock", "image3"), "La esquina del infinito"))
                        .reproduction(36L)
                        .duration(3.58)
                        .build(),
                Track.builder()
                        .id(4L)
                        .name("En el Baldio")
                        .idAlbum(new Album(3L, new Artista(3L, "La Renga", "Rock", "image3"), "La esquina del infinito"))
                        .reproduction(48L)
                        .duration(4.20)
                        .build(),
                Track.builder()
                        .id(5L)
                        .name("Veneno")
                        .idAlbum(new Album(3L, new Artista(3L, "La Renga", "Rock", "image3"), "La esquina del infinito"))
                        .reproduction(52L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(6L)
                        .name("O tu o ninguna")
                        .idAlbum(new Album(4L, new Artista(4L, "Luis Miguel", "Romantico", "image4"), "Romance"))
                        .reproduction(52L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(7L)
                        .name("Si tu te atreves")
                        .idAlbum(new Album(4L, new Artista(4L, "Luis Miguel", "Romantico", "image4"), "Romance"))
                        .reproduction(52L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(8L)
                        .name("Sabor a mi")
                        .idAlbum(new Album(4L, new Artista(4L, "Luis Miguel", "Romantico", "image4"), "Romance"))
                        .reproduction(52L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(9L)
                        .name("Pasos de cero")
                        .idAlbum(new Album(5L, new Artista(5L, "Pablo Alboran", "Romantico", "image5"), "Prometo"))
                        .reproduction(520L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(10L)
                        .name("Por fin")
                        .idAlbum(new Album(5L, new Artista(5L, "Pablo Alboran", "Romantico", "image5"), "Prometo"))
                        .reproduction(53L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(11L)
                        .name("Recuerdame")
                        .idAlbum(new Album(5L, new Artista(5L, "Pablo Alboran", "Romantico", "image5"), "Prometo"))
                        .reproduction(28L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(12L)
                        .name("Quien")
                        .idAlbum(new Album(5L, new Artista(5L, "Pablo Alboran", "Romantico", "image5"), "Prometo"))
                        .reproduction(72L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(13L)
                        .name("La niña de la escuela")
                        .idAlbum(new Album(7L, new Artista(7L, "Tini Stoessel", "Pop", "image7"), "Quiero volver"))
                        .reproduction(75L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(14L)
                        .name("Fresa")
                        .idAlbum(new Album(7L, new Artista(7L, "Tini Stoessel", "Pop", "image7"), "Quiero volver"))
                        .reproduction(12L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(15L)
                        .name("Mienteme")
                        .idAlbum(new Album(7L, new Artista(7L, "Tini Stoessel", "Pop", "image7"), "Quiero volver"))
                        .reproduction(28L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(16L)
                        .name("Que mas pues?")
                        .idAlbum(new Album(8L, new Artista(8L, "Maria Becerra", "Pop", "image8"), "Animal"))
                        .reproduction(200L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(17L)
                        .name("Mi debilidad")
                        .idAlbum(new Album(8L, new Artista(8L, "Maria Becerra", "Pop", "image8"), "Animal"))
                        .reproduction(52L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(18L)
                        .name("Por primera vez")
                        .idAlbum(new Album(10L, new Artista(10L, "Camilo", "Pop latino", "image10"), "Por Primera vez"))
                        .reproduction(72L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(19L)
                        .name("Vida de rico")
                        .idAlbum(new Album(10L, new Artista(10L, "Camilo", "Pop latino", "image10"), "Por Primera vez"))
                        .reproduction(72L)
                        .duration(3.59)
                        .build(),
                Track.builder()
                        .id(20L)
                        .name("Medialuna")
                        .idAlbum(new Album(10L, new Artista(10L, "Camilo", "Pop latino", "image10"), "Por Primera vez"))
                        .reproduction(72L)
                        .duration(3.59)
                        .build());
    }
}