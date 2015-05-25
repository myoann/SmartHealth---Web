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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
            PrintWriter out = response.getWriter();
            //les valeurs doivent ÃƒÂªtre reprisent de la classe utilisateurs.modeles.utilisateur.java
            //les valeurs doivent être reprisent de la classe utilisateurs.modeles.utilisateur.java
            out.print("{"
                    + "\"mail\": \"fjauvat@gmail.com\","
                    + "\"dateNaissance\": \"28/04/1991\","
                    +"\"taille\":\"187\","
                    +"\"poids\":\"85\""
                    + "}");
        }
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
        
        if(request.getParameter("useFunctionServer").equals("modificationProfil")){
            System.out.println(request.getParameter("userId"));
            System.out.println(request.getParameter("dateDuJour"));
            System.out.println(request.getParameter("userEmail"));
            System.out.println(request.getParameter("userDateNaissance"));
            System.out.println(request.getParameter("userPoids"));
            System.out.println(request.getParameter("userTaille"));
            System.out.println(request.getParameter("userNom"));
            System.out.println(request.getParameter("userPrenom"));
        }
        else if(request.getParameter("useFunctionServer").equals("sauvegardeActivitee")){
            System.out.println(request.getParameter("userId"));
            System.out.println(request.getParameter("timeDebutActivite"));
            System.out.println(request.getParameter("timeFinActivite"));
            System.out.println(request.getParameter("latitude"));
            System.out.println(request.getParameter("longitude"));
            System.out.println(request.getParameter("rythmeCardiaque"));
            System.out.println(request.getParameter("podometre"));
                        
        }
        //this.getServletContext().getRequestDispatcher("/").forward(request, response);
        Utilisateur u = new Utilisateur();
        u.setId(request.getParameter("id"));
        Utilisateur utilisateur = gestionnaireUtilisateur.readUser(u);
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.FRENCH);
        Date date;
        Activite a = new Activite();
        try {
            date = format.parse(request.getParameter("date"));
            a.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[][] itineraire= {{"43.6980876","43.6980876","43.6980876","43.6980876"},{"7.215362199999999","7.225365199999999","7.235372199999999","7.255375199999999"}};
        a.setFrequenceCardiaque(Integer.parseInt(request.getParameter("frequenceCardiaque")));
        a.setNombrePas(Integer.parseInt(request.getParameter("nombrePas")));
        a.setMetres(Integer.parseInt(request.getParameter("metres")));
        a.setMinutes(Integer.parseInt(request.getParameter("minutes")));
        a.setVitesse(Integer.parseInt(request.getParameter("vitesse")));
        a.setType(request.getParameter("type"));
        a.setItineraire(itineraire);
        utilisateur.getActivites().add(a);
        
        this.getServletContext().getRequestDispatcher("/").forward(request, response);
    }
}
