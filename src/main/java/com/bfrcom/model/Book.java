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

    @Setter
    @Getter
    @Column(name = "name")
    public String name;

    @Setter
    @Getter
    @Column(name = "author")
    public String author;

    @Setter
    @Getter
    @Column(name = "year")
    public Integer year;

    @Setter
    @Getter
    @Column(name = "description")
    public String description;

    @Setter
    @Getter
    @Column(name = "userUploadId")
    public Long userUploadId;

    @Setter
    @Getter
    @Column(name = "coverImageId")
    public Long coverImageId;

    @Setter
    @Getter
    @Column(name = "pdfId")
    public Long pdfId;
}
