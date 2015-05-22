/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.util.Date;

/**
 *
 * @author user
 */
public class Activite {
    
    private String id;
    
    private Date date;
    
    private Integer nombrePas;
    
    private Integer frequenceCardiaque;
    
    private Integer minutes;
    
    private Integer metres;
    
    private String type;
    
    private String[] itineraire;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNombrePas() {
        return nombrePas;
    }

    public void setNombrePas(Integer nombrePas) {
        this.nombrePas = nombrePas;
    }

    public Integer getFrequenceCardiaque() {
        return frequenceCardiaque;
    }

    public void setFrequenceCardiaque(Integer frequenceCardiaque) {
        this.frequenceCardiaque = frequenceCardiaque;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getItineraire() {
        return itineraire;
    }

    public void setItineraire(String[] itineraire) {
        this.itineraire = itineraire;
    }
    
}
