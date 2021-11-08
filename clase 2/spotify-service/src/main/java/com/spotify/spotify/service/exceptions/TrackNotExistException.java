package com.spotify.spotify.service.exceptions;

public class TrackNotExistException extends Throwable {
    public TrackNotExistException(String message) {
        super(message);
    }
}
