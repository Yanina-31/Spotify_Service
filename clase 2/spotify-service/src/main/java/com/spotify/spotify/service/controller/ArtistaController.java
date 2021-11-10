package com.spotify.spotify.service.controller;
import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.service.impl.ArtistaService;
import com.spotify.spotify.service.service.impl.TrackService;
import com.spotify.spotify.service.types.model.Artista;
import com.spotify.spotify.service.types.model.Track;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/artist")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private TrackService trackService;

    @GetMapping(path = "/")
    public String initial() {
        return "En esta pagina podra encontrar Artistas";
    }

    @GetMapping(path = "/{artistId}")
    public Artista retriveArtista(@PathVariable("artistId") Long artistId) {
        //log.info("artistId {}", artistId);
        return artistaService.getArtista(artistId);
    }

    @GetMapping(path = "/artists/")
    public Iterable<Artista> retriveArtistas() {
        return artistaService.getArtistas();
    }

    @PostMapping(path = "/artist")
    public Artista createArtista(@Validated @RequestBody ArtistaRequest request) {
        return artistaService.createArtista(request);
    }
    @PutMapping(path = "/{artistId}")
    public Artista updateArtista(@Validated @RequestBody ArtistaRequest request, @PathVariable("artistId") Long artistId) {
        return artistaService.updateArtista(request, artistId);
    }

    @DeleteMapping(path ="/{artistId}")
    public Artista deleteArtista(@PathVariable("artistId") Long artistId) {
        return artistaService.deleteArtista(artistId);
    }

    /*@GetMapping(path = "/artist/{artistId}/songs/rank")
    public List<Track> getTracks() {
        return artistaService.getTracks();
    }*/


    /*@GetMapping(path = "/artist/rank")
    public List<Artista> getArtistasTop5() {
        return artistaService.getArtistasTop5();
    }*/

}




