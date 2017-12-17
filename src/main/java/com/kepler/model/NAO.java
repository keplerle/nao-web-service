package com.kepler.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nao")

@Getter
@Setter
@ToString
public class NAO implements java.io.Serializable {
    @Id
    @Column(name = "ip", unique = true, nullable = false)
    private String ip;

    @Column(name = "nom")
    private String nom;

    @Column(name = "mailprof")
    private String mailprof;

    @Column(name = "etat_robot")
    private int etat_robot;

    @Column(name = "operande")
    private boolean operande;

    @Column(name = "operateur")
    private boolean operateur;

    @Column(name = "code_signe")
    private int code_signe;




}
