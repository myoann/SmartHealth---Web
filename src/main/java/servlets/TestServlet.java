/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mongodb.MongoClient;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeles.Utilisateur;
import forms.ConnexionForm;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.annotation.WebServlet;
import gestionnaire.GestionnaireUtilisateur;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import modeles.Activite;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @EJB
    GestionnaireUtilisateur gestionnaireUtilisateur;
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        response.setContentType("application/json");
        System.out.println("Dans le doGet");
        
        System.out.println("request.getParameter(\"useFunctionServer\")"+request.getParameter("useFunctionServer"));
        
        if(request.getParameter("useFunctionServer").equals("getProfil")){
            Utilisateur u = new Utilisateur();
            u.setId(request.getParameter("userId"));
            
            String nom = "";
            String email = "";
            String dateNaissance = "";
            String taille = "";
            String poids = "";
            Utilisateur util = gestionnaireUtilisateur.readUser(u);
            if(util != null) {
                nom = util.getName();
                email = util.getEmail();
                dateNaissance = (String)util.getNaissance();
                taille = (String)util.getTaille();
                poids = (String)util.getPoids();
            }
            PrintWriter out = response.getWriter();
            //les valeurs doivent être reprisent de la classe utilisateurs.modeles.utilisateur.java
            out.print("{"
                    + "\"nom\": \""+nom+"\","
                    + "\"mail\": \""+email+"\","
                    + "\"dateNaissance\": \""+dateNaissance+"\","
                    +"\"taille\":\""+taille+"\","
                    +"\"poids\":\""+poids+"\""
                    + "}");
        }
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
        
        if(request.getParameter("useFunctionServer").equals("modificationProfil")){
            System.out.println(request.getParameter("userId"));
            System.out.println(request.getParameter("userEmail"));
            System.out.println(request.getParameter("userDateNaissance"));
            System.out.println(request.getParameter("userPoids"));
            System.out.println(request.getParameter("userTaille"));
            System.out.println(request.getParameter("userNom"));
            
            Utilisateur u = new Utilisateur();
            u.setId(request.getParameter("userId"));
            
            Utilisateur util = gestionnaireUtilisateur.readUser(u);
            if(util != null) {
                u.setName(request.getParameter("userNom"));
                u.setEmail(request.getParameter("userEmail"));
                u.setPoids(request.getParameter("userPoids"));
                u.setTaille(request.getParameter("userTaille"));
                u.setNaissance(request.getParameter("userDateNaissance"));
                u.setMotdepasse(util.getMotdepasse());
                u.setObjectif(util.getObjectif());
                gestionnaireUtilisateur.updateUser(u);
            }
        }
        else if(request.getParameter("useFunctionServer").equals("sauvegardeActivitee")){
            System.out.println(request.getParameter("userId"));
            System.out.println(request.getParameter("timeDebutActivite"));
            System.out.println(request.getParameter("timeFinActivite"));
            System.out.println(request.getParameter("latitude"));
            System.out.println(request.getParameter("longitude"));
            System.out.println(request.getParameter("rythmeCardiaque"));
            System.out.println(request.getParameter("podometre"));
            System.out.println(request.getParameter("vitesse"));
            System.out.println(request.getParameter("metres"));
            System.out.println(request.getParameter("type"));
            DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(Long.parseLong(request.getParameter("timeDebutActivite")));
            Activite a = new Activite();
            long duree = 0;
            try {
                Date date = df.parse(df.format(cal.getTime()));
                a.setDate(date);
                
                Calendar calFin = Calendar.getInstance();
                calFin.setTimeInMillis(Long.parseLong(request.getParameter("timeFinActivite")));
                Date dateFin = df.parse(df.format(calFin.getTime()));
                a.setDateFin(dateFin);
                duree = dateFin.getTime() - date.getTime();
                
            } catch (ParseException ex) {
                Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String latitudeS = request.getParameter("latitude").substring(1, request.getParameter("latitude").length()-1) ;
            String longitudeS = request.getParameter("longitude").substring(1, request.getParameter("longitude").length()-1) ;
            String[] latitude = latitudeS.split(",");
            String[] longitude = longitudeS.split(",");
            String[][] itineraire= {latitude,longitude};
            a.setFrequenceCardiaque(Integer.parseInt(request.getParameter("rythmeCardiaque")));
            a.setMetres((int)Float.parseFloat(request.getParameter("metres")));
            a.setMinutes((int)TimeUnit.MILLISECONDS.toMinutes(duree));
            a.setVitesse(Integer.parseInt(request.getParameter("vitesse")));
            a.setType(request.getParameter("type"));
            a.setNombrePas(Integer.parseInt(request.getParameter("podometre")));
            a.setItineraire(itineraire);
            
            Utilisateur u = new Utilisateur();
            u.setId(request.getParameter("userId"));
            Utilisateur utilisateur = gestionnaireUtilisateur.readUser(u);
            utilisateur.getActivites().add(a);
            
            gestionnaireUtilisateur.addActivite(utilisateur);
            
        }else if(request.getParameter("useFunctionServer").equals("verifLogin")){
            System.out.println(request.getParameter("email"));
            System.out.println(request.getParameter("password"));
            
            Utilisateur u = new Utilisateur();
            u.setEmail(request.getParameter("email"));
            Utilisateur utilisateur = gestionnaireUtilisateur.checkUser(u);
            String id = ""; 
            if(utilisateur != null) {
                if(utilisateur.getMotdepasse().equals(request.getParameter("password"))) {
                    id = utilisateur.getId();
                }
            }
            PrintWriter out = response.getWriter();
            //les valeurs doivent être reprisent de la classe utilisateurs.modeles.utilisateur.java
            
            out.print("{"
                    + "\"id\": \""+id+"\""
                    + "}");
            
        }
    }
}