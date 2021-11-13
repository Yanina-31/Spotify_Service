package com.spotify.spotify.service.types.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idAlbum")
    private long idAlbum;
    @ManyToOne
    @JoinColumn(name = "idArtist")
    private Artista idArtist;
    //@Column(name = "name")
    private String name;
}


