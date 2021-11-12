package com.spotify.spotify.service.service;

import com.spotify.spotify.service.controller.request.AlbumRequest;
import com.spotify.spotify.service.exceptions.AlbumNotExistException;
import com.spotify.spotify.service.types.model.Album;


public interface IAlbumService {

    Album getAlbum(Long albumId) throws AlbumNotExistException;

    Iterable<Album> getAlbums();

    Album createAlbum(AlbumRequest request);

    Album updateAlbum(AlbumRequest request, Long albumId) throws AlbumNotExistException;

    Album deleteAlbum(Long albumId) throws AlbumNotExistException;
}
