package com.spotify.spotify.service.exceptions;

public class TrackExistsException extends RuntimeException {

    //private static final long serialVersionUID = 1L;

    public TrackExistsException(String message) {
        super(message);
    }
}
