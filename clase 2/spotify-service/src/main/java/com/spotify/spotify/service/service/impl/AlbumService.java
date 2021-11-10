package com.spotify.spotify.service.service.impl;
import com.spotify.spotify.service.controller.request.AlbumRequest;
import com.spotify.spotify.service.exceptions.AlbumExistsException;
import com.spotify.spotify.service.exceptions.AlbumNotExistExcetion;
import com.spotify.spotify.service.repository.AlbumRepository;
import com.spotify.spotify.service.service.IAlbumService;
import com.spotify.spotify.service.types.mapper.AlbumMapper;
import com.spotify.spotify.service.types.model.Album;
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
public class AlbumService implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumRepository albumRepository;

    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    private Map<Long, Album> albumMap = new HashMap<>();

    @PostConstruct
    public void init() {
        if (albums != null && !albums.isEmpty()) {
            albums.stream().forEach(album -> {
                albumRepository.save(album);
            });
        }
    }

    public Album getAlbum(Long albumId) {
        return albumRepository.findById(albumId).get();
    }

    public Album deleteAlbum(Long albumId) {
        albumRepository.deleteById(albumId);
        return null;
    }

    public Iterable<Album> getAlbums() {
        return albumRepository.findAll();
    }

    public Album createAlbum(AlbumRequest request) {
        Album album = albumMapper.apply(request);
        if(request.getIdAlbum() != null && albumRepository.findById(request.getIdAlbum()) != null) {
            log.error("El Album ya existe");
            throw new AlbumExistsException("El Album ya existe");
        }else {
            albumRepository.save(albumMapper.apply(request));
        }
        return album;
    }

    @SneakyThrows
    @Override
    public Album updateAlbum(AlbumRequest request, Long albumId) {
        Album album = null;
        if(albumRepository.findById(albumId) != null){
            album = albumMapper.apply(request);
            albumRepository.save(album);
        } else {
            log.error("El Album NO existe");
            throw new AlbumNotExistExcetion("El Album NO existe");
        }
        return album;
    }
}


