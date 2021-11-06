package com.spotify.spotify.service.exceptions;

public class AlbumExistsException extends RuntimeException{
    public AlbumExistsException(String message) {
        super(message);
    }
}

