package com.spotify.spotify.service.repository;

import com.spotify.spotify.service.types.model.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {

    @Query(value = "select distinct t.name, art.ID_ARTIST, art.NAME, t.REPRODUCTION\n" +
            "From Track t inner join Album  alb on t.id_album= alb.id_album\n" +
            "inner join Artista art on alb.id_artist =  art.id_artist \n" +
            "where art.id_artist\n" +
            "group by art.id_artist,t.name, t.reproduction, art.name\n" +
            "order by t.reproduction desc", nativeQuery = true)
    List<Track> rankPopularesArtist(Long idArtist);

    @Query(value = "select top 5 * from track order by reproduction desc", nativeQuery = true)
    List<Track> rankPopulares();

}