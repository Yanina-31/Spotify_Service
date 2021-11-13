package com.spotify.spotify.service.repository;

import com.spotify.spotify.service.types.model.Artista;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Long> {
    Artista findByIdArtist(Long idArtist);

    Artista findByName(String name);

    List<Artista> findAll();

    @Query(value = "select top 5 art.id_artist, art.name, art.genre, art.image \n" +
            "from track t join  album alb on alb.id_album = t.id_album join artista art on art.id_artist=alb.id_artist \n" +
            "group by art.id_artist, art.name, art.genre, art.image \n" +
            "order by sum(reproduction) desc", nativeQuery = true)

    List<Artista> top5Artistas();

}