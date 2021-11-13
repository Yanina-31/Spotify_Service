package com.spotify.spotify.service.service;

import com.spotify.spotify.service.controller.request.TrackRequest;
import com.spotify.spotify.service.exceptions.TrackNotExistException;
import com.spotify.spotify.service.types.model.Track;
public interface ITrackService {

    Track getTrack(Long trackId) throws TrackNotExistException;

    Iterable<Track> getTracks();

    Track createTrack(TrackRequest request);

    Track updateTrack(TrackRequest request, Long trackId);

    Track deleteTrack(Long trackId) throws TrackNotExistException;
}
