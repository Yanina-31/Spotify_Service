package com.spotify.spotify.service.controller.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArtistaRequest {
    private Long idArtist;
    private String name;
    private String genre;
    private String image;
}
