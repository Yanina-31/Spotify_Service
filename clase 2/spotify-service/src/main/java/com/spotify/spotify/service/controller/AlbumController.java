package com.spotify.spotify.service.controller;
import com.spotify.spotify.service.controller.request.AlbumRequest;
import com.spotify.spotify.service.service.impl.AlbumService;
import com.spotify.spotify.service.types.model.Album;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping(path = "/")
    public String initial() {
        return "En esta pagina podra encontrar Albums";
    }

    @GetMapping(path = "/{albumId}")
    public Album retriveAlbum(@PathVariable("albumId") Long albumId) {
        return albumService.getAlbum(albumId);
    }

    @GetMapping(path = "/albums/")
    public List<Album> retriveAlbums() {
        return albumService.getAlbums();
    }

    @PostMapping(path = "/album")
    public Album createAlbum(@Validated @RequestBody AlbumRequest request) {
        return albumService.createAlbum(request);
    }

    @PutMapping(path = "/{albumId}")
    public Album updateAlbum(@Validated @RequestBody AlbumRequest request, @PathVariable("albumId") Long albumId) {
        return albumService.updateAlbum(request, albumId);
    }

    @DeleteMapping(path ="/{albumId}")
    public Album deleteAlbum(@PathVariable("albumId") Long albumId) {
        return albumService.deleteAlbum(albumId);
    }
}


