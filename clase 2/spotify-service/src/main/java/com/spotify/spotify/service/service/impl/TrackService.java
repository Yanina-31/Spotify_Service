package com.spotify.spotify.service.service.impl;
import com.spotify.spotify.service.controller.request.TrackRequest;
import com.spotify.spotify.service.exceptions.TrackExistsException;
import com.spotify.spotify.service.exceptions.TrackNotExistException;
import com.spotify.spotify.service.service.ITrackService;
import com.spotify.spotify.service.types.mapper.TrackMapper;
import com.spotify.spotify.service.types.model.Track;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TrackService implements ITrackService {
    @Autowired
    private TrackMapper trackMapper;

    @Qualifier("tracks")
    @Autowired
    private List<Track> tracks;

    @PostConstruct
    public void init() {
        trackMap = new HashMap<>();
        tracks.stream().forEach(track -> {
            trackMap.put(track.getId(), track);
        });
    }

    private Map<Long, Track> trackMap;

    public Track getTrack(Long trackId) {
        return trackMap.get(trackId);
    }

    @Override
    public List<Track> getTracks() {
        return new ArrayList<>(trackMap.values());
    }

    public Track deleteTrack(Long trackId) {
        return trackMap.remove(trackId);
    }


    public Track createTrack(TrackRequest request) {
        Track track = trackMapper.apply(request);
        if (trackMap.get(request.getId()) == null) {
            trackMap.put(request.getId(), trackMapper.apply(request));
        } else{
            log.error("Track with id {} already exists", request.getId());
        throw new TrackExistsException("Track with id " + request.getId() + " already exists");
        }
        return track;
    }
    @SneakyThrows
    @Override
    public Track updateTrack(TrackRequest request, Long trackId) {
        Track track = trackMap.get(trackId);
        if(track != null) {
            track.setId(request.getId());
            track.setName(request.getName());
            track.setIdArtist(request.getIdArtist());
            track.setIdAlbum(request.getIdAlbum());
            track.setReproduction(request.getReproduction());
            track.setDuration(request.getDuration());
            trackMap.put(trackId, track);
        } else {
            log.error("Track with id {} does not exist", trackId);
            throw new TrackNotExistException("Track with id " + trackId + " does not exist");
        }
        return track;
    }

    public Track incrementReproduction(Long trackId) throws TrackNotExistException {
        Track track = trackMap.get(trackId);
        if(track != null) {
            track.setReproduction(track.getReproduction() + 1);
            trackMap.put(trackId, track);
        } else {
            log.error("Track with id {} does not exist", trackId);
            throw new TrackNotExistException("Track with id " + trackId + " does not exist");
        }
        return track;
    }
}
