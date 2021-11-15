package com.spotify.spotify.service.repository;

import com.spotify.spotify.service.types.model.Artista;
import com.spotify.spotify.service.types.model.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {
    //Track findById(Long id);

}