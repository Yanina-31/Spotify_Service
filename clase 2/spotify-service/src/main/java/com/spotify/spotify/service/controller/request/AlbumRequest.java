package com.spotify.spotify.service.controller.request;

import com.spotify.spotify.service.types.model.Artista;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
@Builder
@Data
public class AlbumRequest {
    private long idAlbum;
    private Artista idArtist;
    @NotBlank(message = "The name field cannot be null or empty")
    private String name;
}
