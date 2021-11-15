package com.spotify.spotify.service.service.impl;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.exceptions.ArtistaExistsException;
import com.spotify.spotify.service.exceptions.ArtistaNotExistException;
import com.spotify.spotify.service.repository.ArtistaRepository;
import com.spotify.spotify.service.service.IArtistaService;
import com.spotify.spotify.service.types.mapper.ArtistaMapper;
import com.spotify.spotify.service.types.model.Artista;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ArtistaService implements IArtistaService {
    @Autowired
    private ArtistaMapper artistaMapper;
    @Autowired
    private ArtistaRepository artistaRepository;
    @Qualifier("artistas")
    @Autowired
    private List<Artista> artistas;
    private Map<Long, Artista> artistaMap = new HashMap<>();

    @PostConstruct
    public void init() {
        if (artistas != null && !artistas.isEmpty()) {
            artistas.stream().forEach(artista -> {
                artistaRepository.save(artista);

            });
        }

    }

    @SneakyThrows
    @Override
    public Artista getArtista(Long artistId) {
        try {
            return artistaRepository.findById(artistId).get();
        } catch (Exception e) {
            throw new ArtistaNotExistException("The artist doesn't not exist");
        }
    }

    @SneakyThrows
    @Override
    public Artista deleteArtista(Long artistId) {
        try {
            if (artistaRepository.findById(artistId) != null) {
                Artista artista = artistaRepository.findById(artistId).get();
                artistaRepository.deleteById(artistId);
                return artista;
            }
        } catch (Exception e) {
            log.error("Artist already exists");
            throw new ArtistaNotExistException("The artist doesn't not exist");
        }
        return null;
    }


    public Iterable<Artista> getArtistas() {
        return artistaRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Artista createArtista(ArtistaRequest request) {
        Artista artista = artistaMapper.apply(request);
        if (request.getIdArtist() != null && artistaRepository.findById(request.getIdArtist()) != null) {
            log.error("Artist already exists");
            throw new ArtistaExistsException("Error the Id is created automatically");
        } else {
            artista = artistaRepository.save(artistaMapper.apply(request));
        }
        return artista;
    }

    @SneakyThrows
    @Override
    public Artista updateArtista(ArtistaRequest request, Long artistId) {
        try {
            Artista artista = artistaRepository.findById(artistId).get();
            if (request.getIdArtist() != null && artistaRepository.findById(request.getIdArtist()) != null) {
                artista.setIdArtist(artistId);
                artistaRepository.save(artistaMapper.apply(request));
            } else {
                log.error("Artist doesn't  not exist");
                throw new ArtistaNotExistException("The artist doesn't  not exist");
            }
            return artista;
        } catch (Exception e) {
            throw new ArtistaNotExistException("The artist doesn't  not exist");
        }
    }

    public List<Artista> getTop5Artistas() {
        return artistaRepository.top5Artistas();
    }
}

