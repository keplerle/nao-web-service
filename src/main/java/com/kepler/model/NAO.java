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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Id
    @Column(name = "ip")
    private String ip;

    @Column(name = "nom")
    private String nom;

    @Column(name = "etat_robot")
    private int etat_robot;

    @Column(name = "temperature_moteur")
    private int temperature_moteur;

    @Column(name = "temperature_hardware")
    private int temperature_hardware;

    @Column(name = "batterie")
    private int batterie;

    @Column(name = "operande")
    private boolean operande;

    @Column(name = "operateur")
    private boolean operateur;

    @Column(name = "plus")
    private boolean plus;

    @Column(name = "moins")
    private boolean moins;

    @Column(name = "multiple")
    private boolean multiple;

    @Column(name = "divise")
    private boolean divise;




}
