package com.spotify.spotify.service.repository;
import com.spotify.spotify.service.controller.request.AlbumRequest;
import com.spotify.spotify.service.types.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> findByIdAlbum(Long idAlbum);

    Album findByName(String name);

}
