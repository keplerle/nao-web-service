package com.kepler.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "Prof")

@Getter
@Setter
@ToString
public class Prof implements java.io.Serializable {


    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", unique = true, nullable = false)
    //private Long id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Id
    @Column(name = "mail",  unique = true, nullable = false)
    private String mail;

    @Column(name = "password", length = 50)
    private String password;
}
