package com.spotify.spotify.service.repository;

import com.spotify.spotify.service.types.model.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {
    //Track findById(Long id);

    //Track findByName(String name);
}
