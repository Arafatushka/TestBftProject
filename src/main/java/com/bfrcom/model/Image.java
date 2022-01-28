package com.bfrcom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "image", schema = "test")
public class Image {
    @Setter
    @Getter
    @Id
    @SequenceGenerator(name="image_seq", allocationSize = 1, sequenceName = "test.image_seq")
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id")
    public long id;

    @Setter
    @Getter
    @Column(name = "blob")
    public byte [] blob;
}
