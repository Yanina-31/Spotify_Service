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
                    .name("Mariposa Tecnicolor")
                    .idArtist(2L)
                    .idAlbum(1L)
                    .reproduction(10L)
                    .duration(3.23)
                    .build(),
            Track.builder()
                    .name("Mariposa Traicionera")
                    .idArtist(2L)
                    .idAlbum(2L)
                    .reproduction(252L)
                    .duration(3.20)
                    .build(),
            Track.builder()
                    .name("A brillar mi amor")
                    .idArtist(2L)
                    .idAlbum(3L)
                    .reproduction(36L)
                    .duration(3.58)
                    .build(),
            Track.builder()
                    .name("Caminito al costado del mundo")
                    .idArtist(1L)
                    .idAlbum(4L)
                    .reproduction(48L)
                    .duration(4.20)
                    .build(),
            Track.builder()
                    .name("Por debajo de la mesa")
                    .idArtist(1L)
                    .idAlbum(5L)
                    .reproduction(52L)
                    .duration(3.59)
                    .build());
    }
}
