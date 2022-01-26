package com.bfrcom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="book", schema = "test")
public class Book {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id")
    public Long id;

    @Column (name = "name")
    public String name;

    @Column (name = "year")
    public Integer year;
}
