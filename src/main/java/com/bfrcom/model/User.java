package com.bfrcom.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "user", schema = "test")
public class User {
    @Setter
    @Getter
    @Id
    @SequenceGenerator(name="user_seq", allocationSize = 1, sequenceName = "test.user_seq")
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id")
    public Long id;

    @Setter
    @Getter
    @Column(name = "name")
    public String name;

    @Setter
    @Getter
    @Column(name = "surname")
    public String surname;

    @Setter
    @Getter
    @Column(name = "lastLoginDate")
    public Date lastLoginDate;
}
