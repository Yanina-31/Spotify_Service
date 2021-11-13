package com.spotify.spotify.service.service;

import com.spotify.spotify.service.controller.request.TrackRequest;
import com.spotify.spotify.service.types.model.Track;
public interface ITrackService {

    Track getTrack(Long trackId);

    Iterable<Track> getTracks();

    Track createTrack(TrackRequest request);

    Track updateTrack(TrackRequest request, Long trackId);

    Track deleteTrack(Long trackId);

}
