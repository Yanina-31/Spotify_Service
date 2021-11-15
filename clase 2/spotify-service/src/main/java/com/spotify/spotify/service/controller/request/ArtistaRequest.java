package com.spotify.spotify.service.controller.request;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
@Builder
@Data
public class ArtistaRequest {
    private Long idArtist;
    @NotBlank(message = "The name field cannot be null or empty")
    private String name;
    private String genre;
    private String image;
}
