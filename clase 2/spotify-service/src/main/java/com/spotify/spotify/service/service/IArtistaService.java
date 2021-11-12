package com.spotify.spotify.service.service;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.exceptions.AlbumNotExistException;
import com.spotify.spotify.service.exceptions.ArtistaNotExistException;
import com.spotify.spotify.service.types.model.Artista;

public interface IArtistaService {
    Artista getArtista(Long artistId) throws AlbumNotExistException, ArtistaNotExistException;

    Iterable<Artista> getArtistas();

    Artista createArtista(ArtistaRequest request);

    Artista updateArtista(ArtistaRequest request, Long artistId);

    Artista deleteArtista(Long artistId) throws ArtistaNotExistException;
}
