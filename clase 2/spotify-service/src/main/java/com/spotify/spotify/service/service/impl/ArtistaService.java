package com.spotify.spotify.service.service.impl;
import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.exceptions.ArtistaExistsException;
import com.spotify.spotify.service.exceptions.ArtistaNotExistExcetion;
import com.spotify.spotify.service.service.IArtistaService;
import com.spotify.spotify.service.types.mapper.ArtistaMapper;
import com.spotify.spotify.service.types.model.Artista;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ArtistaService implements IArtistaService {

    @Autowired
    private ArtistaMapper artistaMapper;

    @Qualifier("artistas")
    @Autowired
    private List<Artista> artistas;

    @PostConstruct
    public void init() {
        artistaMap = new HashMap<>();
        artistas.stream().forEach(artista -> {
                artistaMap.put(artista.getIdArtist(), artista);
        });
    }

    private Map<Long, Artista> artistaMap;

    public Artista getArtista(Long artistId) {
        return artistaMap.get(artistId);
    }

    public Artista deleteArtista(Long artistId) {
        return artistaMap.remove(artistId);
    }

    public List<Artista> getArtistas(){
        return new ArrayList<>(artistaMap.values());
    }

    public Artista createArtista(ArtistaRequest request) {
        Artista artista = artistaMapper.apply(request);
        if(artistaMap.get(request.getIdArtist()) == null) {
            artistaMap.put(request.getIdArtist(), artistaMapper.apply(request));
        }else {
            log.error("El artista con id {} ya existe", request.getIdArtist());
            throw new ArtistaExistsException("El artista con id " + request.getIdArtist() + " ya existe");
        }
        return artista;
    }

    @SneakyThrows
    @Override
    public Artista updateArtista(ArtistaRequest request, Long artistId) {
        Artista artista = null;
        if(artistaMap.get(artistId) != null) {
            artista = artistaMapper.apply(request);
            artistaMap.remove(request.getIdArtist());
            artistaMap.put(request.getIdArtist(), artista);
        }else {
            log.error("El artista con id {} No existe", request.getIdArtist());
            throw new ArtistaNotExistExcetion("El artista con id " + request.getIdArtist() + " No existe");
        }
        return artista;
    }
}
