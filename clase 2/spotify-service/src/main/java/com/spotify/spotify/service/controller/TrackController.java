package com.spotify.spotify.service.controller;

import com.spotify.spotify.service.controller.request.TrackRequest;
import com.spotify.spotify.service.exceptions.TrackNotExistException;
import com.spotify.spotify.service.service.impl.TrackService;
import com.spotify.spotify.service.types.model.Track;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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

    /*@GetMapping(path = "/spotify/play/track/{trackId}")
    public Track incrementReproduction(@PathVariable("trackId") Long trackId) throws TrackNotExistException {
        return trackService.incrementReproduction(trackId);
    }*/
    /*@GetMapping(path = "/track/rank")
    public List<Track> getTopTracks() {
        return trackService.getTopTracks();
    }*/


}


