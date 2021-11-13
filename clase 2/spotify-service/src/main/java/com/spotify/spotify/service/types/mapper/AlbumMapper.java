package com.spotify.spotify.service.types.mapper;

import com.spotify.spotify.service.controller.request.AlbumRequest;
import com.spotify.spotify.service.types.model.Album;
import org.springframework.stereotype.Component;
import java.util.function.Function;
@Component
public class AlbumMapper implements Function<AlbumRequest, Album> {
    @Override
    public Album apply(AlbumRequest albumRequest) {
        return new Album(albumRequest.getIdAlbum(),
                albumRequest.getIdArtist(),
                albumRequest.getName());
    }
}
