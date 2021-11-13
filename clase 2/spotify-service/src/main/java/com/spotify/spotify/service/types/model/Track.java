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
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private long id;
    //@Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "idAlbum")
    private Album idAlbum;
    //@Column(name = "reproduction")
    private long reproduction;
    //@Column(name = "duration")
    private double duration;

}
