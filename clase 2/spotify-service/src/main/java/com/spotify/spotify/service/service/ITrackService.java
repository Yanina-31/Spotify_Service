package com.spotify.spotify.service.service;

import com.spotify.spotify.service.controller.request.TrackRequest;
import com.spotify.spotify.service.types.model.Track;

import java.util.List;


public interface ITrackService {

    Track getTrack(Long trackId);

    Iterable<Track> getTracks();

    Track createTrack(TrackRequest request);

    Track updateTrack(TrackRequest request, Long trackId);

    Track deleteTrack(Long trackId);

    /*  Track incrementReproduction(Long trackId) throws TrackNotExistException;*/

    /*List<Track> getTopTracks();*/

}
