package com.bfrcom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "image", schema = "test")
public class Image {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    public long id;

    @Column(name = "blob")
    public byte [] blob;
}
