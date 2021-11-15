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
    @SneakyThrows
    @Override
    public Track getTrack(Long trackId) {
        try {
            return trackRepository.findById(trackId).get();
        } catch (Exception e) {
            throw new TrackNotExistException("The track doesn't not exist");
        }
    }


    public Iterable<Track> getTracks() {
        return trackRepository.findAll();
    }
    @SneakyThrows
    @Override
    public Track deleteTrack(Long trackId) {
        try {
            if (trackRepository.findById(trackId) != null) {
                Track track = trackRepository.findById(trackId).get();
                trackRepository.deleteById(trackId);
                return track;
            }
        } catch (Exception e) {
            throw new TrackNotExistException("The track doesn't not exist");
        }
        return null;
    }


    @Override
    public Track createTrack(TrackRequest request) {
        Track track = trackMapper.apply(request);
        if (trackRepository.findById(request.getId()).isPresent()) {
            log.error("Track already exists");
            throw new TrackExistsException("Error the Id is created automatically");
        } else {
            track = trackRepository.save(trackMapper.apply(request));
        }
        return track;
    }

    @SneakyThrows
    @Override
    public Track updateTrack(TrackRequest request, Long trackId) {
        try {
            Track track = trackRepository.findById(trackId).get();
            if (trackRepository.findById(request.getId()) != null) {
                track.setId(trackId);
                trackRepository.save(trackMapper.apply(request));
            } else {
                log.error("Track doesn't  not exist");
                throw new TrackNotExistException("The track doesn't  not exist");
            }
            return track;
        } catch (Exception e) {
            throw new TrackNotExistException("The track doesn't  not exist");
        }
    }
}
