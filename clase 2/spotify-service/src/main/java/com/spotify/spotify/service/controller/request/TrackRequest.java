package com.spotify.spotify.service.controller.request;

import com.spotify.spotify.service.types.model.Album;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
@Builder
@Data
public class TrackRequest {
    private long id;
    @NotBlank(message = "The name field cannot be null or empty")
    private String name;
    private Album idAlbum;
    private long reproduction;
    private double duration;
}
