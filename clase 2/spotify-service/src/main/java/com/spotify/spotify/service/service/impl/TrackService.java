package com.spotify.spotify.service.service.impl;

import com.spotify.spotify.service.controller.request.TrackRequest;
import com.spotify.spotify.service.exceptions.TrackExistsException;
import com.spotify.spotify.service.exceptions.TrackNotExistException;
import com.spotify.spotify.service.repository.TrackRepository;
import com.spotify.spotify.service.service.ITrackService;
import com.spotify.spotify.service.types.mapper.TrackMapper;
import com.spotify.spotify.service.types.model.Album;
import com.spotify.spotify.service.types.model.Track;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TrackService implements ITrackService {
    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackRepository trackRepository;

    @Qualifier("tracks")
    @Autowired
    private List<Track> tracks;

    private Map<Long, Album> albumMap = new HashMap<>();

    @PostConstruct
    public void init() {
        if (tracks != null && !tracks.isEmpty()) {
            tracks.stream().forEach(track -> {
                trackRepository.save(track);
            });
        }
    }

   /* public Track getTrack(Long trackId) {
        return trackRepository.findById(trackId).get();}*/

    public Track getTrack(Long trackId) {
        return trackRepository.findById(trackId).get();
    }


    public Iterable<Track> getTracks() {
        return trackRepository.findAll();
    }

    public Track deleteTrack(Long trackId) {
        trackRepository.deleteById(trackId);
        return null;
    }


    public Track createTrack(TrackRequest request) {
        Track track = trackMapper.apply(request);
        if (request.getId() != null && trackRepository.findById(request.getId()) != null) {
            log.error("El Pinnaper ya existe");
            throw new TrackExistsException("El Pinnaper ya existe");
        } else {
            trackRepository.save(trackMapper.apply(request));
        }
        return track;
    }

    @SneakyThrows
    @Override
    public Track updateTrack(TrackRequest request, Long trackId) {
        Track track = null;
        if (trackRepository.findById(trackId) != null) {
            track = trackMapper.apply(request);
            trackRepository.save(track);
        } else {
            log.error("El Artista NO existe");
            throw new TrackNotExistException("El Artista NO existe");
        }
        return track;
    }

   /* public Track incrementReproduction(Long trackId) throws TrackNotExistException {
        Track track = trackRepository.findById(trackId).get();
        if(track != null) {
            track.setReproduction(track.getReproduction() + 1);
            trackRepository.save(track);
        } else {
            log.error("Track with id {} does not exist", trackId);
            throw new TrackNotExistException("Track with id " + trackId + " does not exist");
        }
        return track;
    }*/

   /* public List<Track> getTopTracks() {
        return new ArrayList<>(trackRepository.save(tracks));
    }*/
}
