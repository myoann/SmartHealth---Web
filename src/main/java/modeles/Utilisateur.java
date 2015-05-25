/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Utilisateur implements Serializable {

    private String id;
 
    private String name;
    
    private String email;

    //private String photo;
    
    private String localisation;
    
    private String motdepasse;

    private String taille;
    
    private String poids;
    
    private String naissance;
    
    private Objectif objectif;
    
    private ArrayList<Activite> activites = new ArrayList<>();
    
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
    /*
    public String getPhoto() {
        return photo;
    }
 
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    */
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

    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
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

    public ArrayList<Activite> getActivites() {
        return activites;
    }

    public void setActivites(ArrayList<Activite> activites) {
        this.activites = activites;
    }
    
}
