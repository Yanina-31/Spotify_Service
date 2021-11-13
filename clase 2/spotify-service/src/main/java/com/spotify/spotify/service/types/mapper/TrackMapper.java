package com.spotify.spotify.service.types.mapper;

import com.spotify.spotify.service.controller.request.TrackRequest;
import com.spotify.spotify.service.types.model.Track;
import org.springframework.stereotype.Component;
import java.util.function.Function;
@Component
public class TrackMapper implements Function<TrackRequest, Track> {
    @Override
    public Track apply(TrackRequest trackRequest) {
        return new Track(trackRequest.getId(),
                trackRequest.getName(),
                trackRequest.getIdAlbum(),
                trackRequest.getReproduction(),
                trackRequest.getDuration());
    }
}
