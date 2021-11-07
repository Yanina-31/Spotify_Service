package com.spotify.spotify.service.configuration;
import com.spotify.spotify.service.types.model.Track;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;

@Configuration
public class TrackConfiguration {
    @Bean(name = "tracks")
    public static List<Track> getTracks(){
        return Arrays.asList(
            Track.builder()
                    .id(1L)
                    .name("Mariposa Tecnicolor")
                    .idArtist(1L)
                    .idAlbum(1L)
                    .reproduction(10L)
                    .duration(3.23)
                    .build(),
            Track.builder()
                    .id(2L)
                    .name("Mariposa Traicionera")
                    .idArtist(2L)
                    .idAlbum(2L)
                    .reproduction(252L)
                    .duration(3.20)
                    .build(),
            Track.builder()
                    .id(3L)
                    .name("A brillar mi amor")
                    .idArtist(3L)
                    .idAlbum(3L)
                    .reproduction(36L)
                    .duration(3.58)
                    .build(),
            Track.builder()
                    .id(4L)
                    .name("Caminito al costado del mundo")
                    .idArtist(4L)
                    .idAlbum(4L)
                    .reproduction(48L)
                    .duration(4.20)
                    .build(),
            Track.builder()
                    .id(5L)
                    .name("Por debajo de la mesa")
                    .idArtist(5L)
                    .idAlbum(5L)
                    .reproduction(52L)
                    .duration(3.59)
                    .build());
    }
}
