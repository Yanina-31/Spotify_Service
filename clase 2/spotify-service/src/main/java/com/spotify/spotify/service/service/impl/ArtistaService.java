package com.spotify.spotify.service.service.impl;
import com.spotify.spotify.service.controller.request.AlbumRequest;
import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.exceptions.AlbumExistsException;
import com.spotify.spotify.service.exceptions.AlbumNotExistExcetion;
import com.spotify.spotify.service.exceptions.ArtistaExistsException;
import com.spotify.spotify.service.exceptions.ArtistaNotExistExcetion;
import com.spotify.spotify.service.repository.AlbumRepository;
import com.spotify.spotify.service.repository.ArtistaRepository;
import com.spotify.spotify.service.repository.TrackRepository;
import com.spotify.spotify.service.service.IArtistaService;
import com.spotify.spotify.service.service.ITrackService;
import com.spotify.spotify.service.types.mapper.ArtistaMapper;
import com.spotify.spotify.service.types.model.Album;
import com.spotify.spotify.service.types.model.Artista;
import com.spotify.spotify.service.types.model.Track;
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

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private TrackRepository trackRepository;

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

    public Artista getArtista(Long artistId) {
        return artistaRepository.findById(artistId).get();
    }

    public Artista deleteArtista(Long artistId) {
        artistaRepository.deleteById(artistId);
        return null;
    }


    public Iterable<Artista> getArtistas(){
        return artistaRepository.findAll();
    }

    public Artista createArtista(ArtistaRequest request) {
        Artista artista = artistaMapper.apply(request);
        if(request.getIdArtist() != null && artistaRepository.findById(request.getIdArtist()) != null) {
            log.error("El Artista ya existe");
            throw new AlbumExistsException("El Artista ya existe");
        }else {
            artistaRepository.save(artistaMapper.apply(request));
        }
        return artista;
    }

    @SneakyThrows
    @Override
    public Artista updateArtista(ArtistaRequest request, Long artistId) {
        Artista artista = null;
        if(artistaRepository.findById(artistId) != null) {
            artista = artistaMapper.apply(request);
            artistaRepository.save(artista);
        }else {
            log.error("El Artista NO existe");
            throw new ArtistaNotExistExcetion("El Artista NO existe");
        }
        return artista;
    }

    /*public Iterable<Track> getTracks() {
        return trackRepository.findAll();
    }*/

  /* public List<Artista> getArtistasTop5() {
        return new ArrayList<>(artistaMap.values());
    }*/
}
