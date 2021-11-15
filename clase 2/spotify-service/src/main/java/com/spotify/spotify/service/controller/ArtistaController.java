package com.spotify.spotify.service.controller;

import com.spotify.spotify.service.controller.request.ArtistaRequest;
import com.spotify.spotify.service.service.impl.ArtistaService;
import com.spotify.spotify.service.service.impl.TrackService;
import com.spotify.spotify.service.types.model.Artista;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
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

    @Operation(summary = "Get a Artist by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Artist",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Artist not found",
                    content = @Content)})

    @GetMapping(path = "/{artistId}")
    public Artista retriveArtista(@PathVariable("artistId") Long artistId) {
        return artistaService.getArtista(artistId);
    }

    @GetMapping(path = "/artists/")
    public Iterable<Artista> retriveArtistas() {
        return artistaService.getArtistas();
    }

    @PostMapping(path = "/artist")
    public Artista createArtista(@Validated @RequestBody ArtistaRequest request) {
        log.info(String.format("Creating artista with name %s", request));
        return artistaService.createArtista(request);
    }

    @PutMapping(path = "/{artistId}")
    public Artista updateArtista(@Validated @RequestBody ArtistaRequest request, @PathVariable("artistId") Long artistId) {
        return artistaService.updateArtista(request, artistId);
    }

    @DeleteMapping(path = "/{artistId}")
    public Artista deleteArtista(@PathVariable("artistId") Long artistId) {
        return artistaService.deleteArtista(artistId);
    }

    //top 5 de artistas populares
    @GetMapping(path = "/artist/rank")
    public List<Artista> retriveArtist() {
        return artistaService.getTop5Artistas();
    }

}







