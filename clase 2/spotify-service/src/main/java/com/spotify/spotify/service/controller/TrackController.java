package com.spotify.spotify.service.controller;

import com.spotify.spotify.service.controller.request.TrackRequest;
import com.spotify.spotify.service.service.impl.TrackService;
import com.spotify.spotify.service.types.model.Track;
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
@RequestMapping(path = "/track")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @GetMapping(path = "/")
    public String initial() {
        return "En esta pagina podra encontrar Track";
    }

    @Operation(summary = "Get a Track by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Track",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Track not found",
                    content = @Content)})

    @GetMapping(path = "{id}")
    public Track retriveTrack(@PathVariable("id") Long id) {
        return trackService.getTrack(id);
    }

    @GetMapping(path = "/tracks")
    public Iterable<Track> retriveTracks() {
        return trackService.getTracks();
    }

    @PostMapping(path = "/track")
    public Track createTrack(@Validated @RequestBody TrackRequest request) {
        log.info(String.format("Creating track with name %s", request));
        return trackService.createTrack(request);
    }

    @PutMapping(path = "/{trackId}")
    public Track updateTrack(@Validated @RequestBody TrackRequest request, @PathVariable("trackId") Long trackId) {
        return trackService.updateTrack(request, trackId);
    }

    @DeleteMapping(path = "/{trackId}")
    public Track deleteTrack(@PathVariable("trackId") Long trackId) {
        return trackService.deleteTrack(trackId);
    }

    //Incrementar el reproduction en uno
    @GetMapping(path = "/spotify/play/track/{trackId}")
    public Track incrementReproduction(@PathVariable("trackId") Long trackId) {
        return trackService.incrementReproduction(trackId);
    }

    //top 5 de canciones populares
    @GetMapping(path = "/track/rank")
    public List<Track> retriveTrack() {
        return trackService.topRank();
    }

    //5 canciones mas populares del artista
    @GetMapping(path = "/artist/{idArtist}/songs/rank")
    public List<Track> retrieveArtist(@PathVariable("idArtist") Long idArtist) {
        return trackService.top5TrackArtist(idArtist);
    }
}



