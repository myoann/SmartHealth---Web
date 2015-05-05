/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Objectif implements Serializable {
    
    private String id;
 
    private String titre;
    
    private String description;
    
    private Integer nombrePas;
    
    private Integer minutes;
    
    private Integer metres;
    
    private Integer veloMetres;
    
    private Integer veloTemps;
    
    private Integer courseTemps;
    
    private Integer courseMetres;
    
    private Integer marcheMetres;
    
    private Integer marcheTemps;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNombrePas() {
        return nombrePas;
    }

    public void setNombrePas(Integer nombrePas) {
        this.nombrePas = nombrePas;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getMetres() {
        return metres;
    }

    public void setMetres(Integer metres) {
        this.metres = metres;
    }

    public Integer getVeloMetres() {
        return veloMetres;
    }

    public void setVeloMetres(Integer veloMetres) {
        this.veloMetres = veloMetres;
    }

    public Integer getVeloTemps() {
        return veloTemps;
    }

    public void setVeloTemps(Integer veloTemps) {
        this.veloTemps = veloTemps;
    }

    public Integer getCourseTemps() {
        return courseTemps;
    }

    public void setCourseTemps(Integer courseTemps) {
        this.courseTemps = courseTemps;
    }

    public Integer getCourseMetres() {
        return courseMetres;
    }

    public void setCourseMetres(Integer courseMetres) {
        this.courseMetres = courseMetres;
    }

    public Integer getMarcheMetres() {
        return marcheMetres;
    }

    public void setMarcheMetres(Integer marcheMetres) {
        this.marcheMetres = marcheMetres;
    }

    public Integer getMarcheTemps() {
        return marcheTemps;
    }

    public void setMarcheTemps(Integer marcheTemps) {
        this.marcheTemps = marcheTemps;
    }
    
}