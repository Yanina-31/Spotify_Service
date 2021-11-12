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
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idArtist;
    private Long idAlbum;
    private String name;
    private Long reproduction;
    private double duration;


    /*@ManyToOne
    @JoinColumn(name ="idAlbum")
    private Album joinAlbum;

    @ManyToOne
    @JoinColumn(name ="idArtist")
    private Artista joinArtist;*/

}
