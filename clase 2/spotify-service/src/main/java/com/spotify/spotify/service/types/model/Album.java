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
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_album")
    private Long idAlbum;
    @Column(name = "id_artist")
    private Long idArtist;
    @Column(name = "name")
    private String name;

}


