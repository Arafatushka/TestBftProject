package com.bfrcom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book", schema = "test")
public class Book {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "author")
    public String author;

    @Column(name = "year")
    public Integer year;

    @Column(name = "description")
    public String description;

    @Column(name = "userUploadId")
    public Long userUploadId;

    @Column(name = "coverImageId")
    public Long coverImageId;

    @Column(name = "pdfId")
    public Long pdfId;
}
