package com.spotify.spotify.service.service.impl;
import com.spotify.spotify.service.controller.request.AlbumRequest;
import com.spotify.spotify.service.exceptions.AlbumExistsException;
import com.spotify.spotify.service.exceptions.AlbumNotExistExcetion;
import com.spotify.spotify.service.service.IAlbumService;
import com.spotify.spotify.service.types.mapper.AlbumMapper;
import com.spotify.spotify.service.types.model.Album;
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
public class AlbumService implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    @PostConstruct
    public void init() {
        albumMap = new HashMap<>();
        albums.stream().forEach(album -> {
            albumMap.put(album.getIdAlbum(), album);
        });
    }

    private Map<Long, Album> albumMap;

    public Album getAlbum(Long albumId) {
        return albumMap.get(albumId);
    }

    public Album deleteAlbum(Long albumId) {
        return albumMap.remove(albumId);
    }

    public List<Album> getAlbums(){
        return new ArrayList<>(albumMap.values());
    }

    public Album createAlbum(AlbumRequest request) {
        Album album = albumMapper.apply(request);
        if(albumMap.get(request.getIdAlbum()) == null) {
            albumMap.put(request.getIdAlbum(), albumMapper.apply(request));
        }else {
            log.error("El Album con id {} ya existe", request.getIdAlbum());
            throw new AlbumExistsException("El Album con id " + request.getIdAlbum() + " ya existe");
        }
        return album;
    }

    @SneakyThrows
    @Override
    public Album updateAlbum(AlbumRequest request, Long albumId) {
        Album album = albumMap.get(albumId);
        if(album != null) {
            album.setName(request.getName());
            album.setIdArtist(request.getIdArtist());
            album.setIdAlbum(request.getIdAlbum());
            albumMap.put(albumId, album);
        }else {
            log.error("El Album con id {} no existe", albumId);
            throw new AlbumNotExistExcetion("El Album con id " + albumId + " no existe");
        }
        return album;
    }

}


