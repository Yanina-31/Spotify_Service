package com.spotify.spotify.service.service.impl;

import com.spotify.spotify.service.controller.request.AlbumRequest;
import com.spotify.spotify.service.exceptions.AlbumExistsException;
import com.spotify.spotify.service.exceptions.AlbumNotExistException;
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

    @Override
    @SneakyThrows
    public Album getAlbum(Long albumId){
        try {
            return albumRepository.findById(albumId).get();
        } catch (Exception e) {
            throw new AlbumNotExistException("The album doesn't not exist");
        }
    }

    @Override
    @SneakyThrows
    public Album deleteAlbum(Long albumId) {
        try {
            if (albumRepository.findByIdAlbum(albumId) != null) {
                Album album = albumRepository.findByIdAlbum(albumId);
                albumRepository.deleteById(albumId);
                return album;
            }
        } catch (Exception e) {
            throw new AlbumNotExistException("The album doesn't not exist");
        }
        return null;
    }

    @Override
    public Iterable<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album createAlbum(AlbumRequest request) {
        Album album = albumMapper.apply(request);
        if (albumRepository.findByIdAlbum(request.getIdAlbum()) != null) {
            log.error("Album already exists");
            throw new AlbumExistsException("Error the Id is created automatically");
        } else {
            album = albumRepository.save(albumMapper.apply(request));
        }
        return album;
    }

    @Override
    @SneakyThrows
    public Album updateAlbum(AlbumRequest request, Long albumId) {
        try {
            Album album = albumRepository.findById(albumId).get();
            if (albumRepository.findByIdAlbum(request.getIdAlbum()) != null) {
                album.setIdAlbum(albumId);
                albumRepository.save(albumMapper.apply(request));
            } else {
                log.error("Album doesn't  not exist");
                throw new AlbumNotExistException("The album doesn't  not exist");
            }
            return album;
        } catch (Exception e) {
            throw new AlbumNotExistException("The album doesn't  not exist");
        }
    }
}


