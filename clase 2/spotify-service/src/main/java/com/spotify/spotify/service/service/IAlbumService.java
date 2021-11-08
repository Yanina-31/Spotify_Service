package com.spotify.spotify.service.service;
import com.spotify.spotify.service.controller.request.AlbumRequest;
import com.spotify.spotify.service.types.model.Album;


public interface IAlbumService {

    Album getAlbum(Long albumId);

    Iterable<Album> getAlbums();

    Album createAlbum(AlbumRequest request);

    Album updateAlbum(AlbumRequest request, Long albumId);

    Album deleteAlbum(Long albumId);
}
