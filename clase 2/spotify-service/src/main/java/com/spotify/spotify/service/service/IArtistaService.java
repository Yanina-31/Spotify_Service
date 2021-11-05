package com.spotify.spotify.service.service;


import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.types.model.Artista;

import java.util.List;

public interface IArtistaService {

    Artista getArtista();

    List<Artista> getArtistas();

    Artista createArtista(ArtistaRequest request);

}
