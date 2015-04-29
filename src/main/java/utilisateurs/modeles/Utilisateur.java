/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.modeles;

import java.util.HashMap;

public class Utilisateur {

    // id will be used for primary key in MongoDB
    // We could use ObjectId, but I am keeping it
    // independent of MongoDB API classes
    private String id;
 
    private String name;
    
    private String email;

    private String country;
    
    private String localisation;
    
    private String motdepasse;

    private HashMap nombrePas;

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
    
    public void setNombrePas(HashMap nombrePas) {
        this.nombrePas = nombrePas;
    }
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
}
