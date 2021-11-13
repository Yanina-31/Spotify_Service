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
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idArtist")
    private long idArtist;
    //@Column(name = "name")
    private String name;
    //@Column(name = "genre")
    private String genre;
   // @Column(name = "image")
    private String image;
}
