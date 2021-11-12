package com.spotify.spotify.service.repository;
import com.spotify.spotify.service.types.model.Artista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Long> {
    List<Artista> findByIdArtist(Long idArtist);

    Artista findByName(String name);
}
