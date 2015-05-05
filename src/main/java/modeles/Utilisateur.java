/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.io.Serializable;
import java.util.HashMap;

public class Utilisateur implements Serializable {

    private String id;
 
    private String name;
    
    private String email;

    private String country;
    
    private String localisation;
    
    private String motdepasse;

    private HashMap<String, Integer> nombrePas;
    
    private HashMap minutes;
    
    private HashMap metres;
    
    private String taille;
    
    private String poids;
    
    private String naissance;
    
    private Objectif objectif;
    
    private boolean admin = false;


    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getLocalisation() {
        return localisation;
    }
 
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
    
    public String getMotdepasse() {
        return motdepasse;
    }
    
    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public HashMap getNombrePas() {
        return nombrePas;
    }
    
    public void setNombrePas(HashMap<String, Integer> nombrePas) {
        this.nombrePas = nombrePas;
    }
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    public HashMap getMinutes() {
        return minutes;
    }

    public HashMap getMetres() {
        return metres;
    }

    public String getTaille() {
        return taille;
    }

    public String getPoids() {
        return poids;
    }

    public String getNaissance() {
        return naissance;
    }

    public boolean isAdmin() {
        return admin;
    }
    
    public void setMinutes(HashMap minutes) {
        this.minutes = minutes;
    }

    public void setMetres(HashMap metres) {
        this.metres = metres;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Objectif getObjectif() {
        return objectif;
    }

    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

}
