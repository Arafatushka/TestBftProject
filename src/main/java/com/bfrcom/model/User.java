package com.bfrcom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user", schema = "test")
public class User {
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

    @Column(name = "surname")
    public String surname;

    @Column(name = "lastLoginDate")
    public Date lastLoginDate;
}
