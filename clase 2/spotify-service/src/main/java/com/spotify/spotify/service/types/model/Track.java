package com.spotify.spotify.service.types.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Track { //extends Album{
    private Long id;
    private String name;
    private Long idAlbum;
    private Long idArtist;
    private Long reproduction;
    private Double duration;
}
