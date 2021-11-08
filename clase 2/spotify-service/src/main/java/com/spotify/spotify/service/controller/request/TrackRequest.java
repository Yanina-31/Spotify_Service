package com.spotify.spotify.service.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class TrackRequest {
    @NotNull(message = "El campo id no puede ser null.")
    private Long id;
    private String name;
    private Long idAlbum;
    private Long idArtist;
    private Long reproduction;
    private Double duration;
}
