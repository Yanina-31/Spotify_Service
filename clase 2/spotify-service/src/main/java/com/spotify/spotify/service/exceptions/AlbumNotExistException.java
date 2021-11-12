package com.spotify.spotify.service.exceptions;

public class AlbumNotExistException extends Throwable {
    public AlbumNotExistException(String message) {
        super(message);
    }
}
