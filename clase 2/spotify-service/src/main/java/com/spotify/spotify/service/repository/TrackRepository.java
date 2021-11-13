package com.spotify.spotify.service.repository;

import com.spotify.spotify.service.types.model.Track;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {
    List<Track> findAll();

    @Transactional
    @Modifying

    @Query(value = "select top 5 * from track order by reproduction desc", nativeQuery = true)
    List<Track> rankPopulares();
}