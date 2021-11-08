package com.spotify.spotify.service.repository;

import com.spotify.spotify.service.types.model.Artista;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistaRepository extends CrudRepository<Artista, Long> {
    List<Artista> findByIdArtist(Long idArtist);

    Artista findByName(String name);
}
