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
@Table(name="track")

public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "id_album")
    private Long idAlbum;
    @Column(name = "id_artist")
    private Long idArtist;
    @Column(name = "reproduction")
    private Long reproduction;
    @Column(name = "duration")
    private double duration;

}
