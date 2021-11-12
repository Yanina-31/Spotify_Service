package com.spotify.spotify.service.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class ArtistaRequest {
    //@NotNull(message = "El campo id no puede ser null.")
    private Long idArtist;
    private String name;
    private String genre;
    private String image;
}
