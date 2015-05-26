/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeles.Utilisateur;
import javax.servlet.annotation.WebServlet;
import gestionnaire.GestionnaireUtilisateur;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
            //les valeurs doivent être reprisent de la classe utilisateurs.modeles.utilisateur.java
            out.print("{"
                    + "\"nom\": \"Jauvat\","
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
        }
        else if(request.getParameter("useFunctionServer").equals("sauvegardeActivitee")){
            System.out.println(request.getParameter("userId"));
            System.out.println(request.getParameter("timeDebutActivite"));
            System.out.println(request.getParameter("timeFinActivite"));
            System.out.println(request.getParameter("latitude"));
            System.out.println(request.getParameter("longitude"));
            System.out.println(request.getParameter("rythmeCardiaque"));
            System.out.println(request.getParameter("podometre"));
            DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(Long.parseLong(request.getParameter("timeDebutActivite")));
            Activite a = new Activite();
            try {
                Date date = df.parse(df.format(cal.getTime()));
                a.setDate(date);
                
                Calendar calFin = Calendar.getInstance();
                calFin.setTimeInMillis(Long.parseLong(request.getParameter("timeFinActivite")));
                Date dateFin = df.parse(df.format(calFin.getTime()));
                a.setDateFin(dateFin);
                
            } catch (ParseException ex) {
                Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String latitudeS = request.getParameter("latitude").substring(1, request.getParameter("latitude").length()-1) ;
            String longitudeS = request.getParameter("longitude").substring(1, request.getParameter("longitude").length()-1) ;
            String[] latitude = latitudeS.split(",");
            String[] longitude = longitudeS.split(",");
            String[][] itineraire= {latitude,longitude};
            a.setFrequenceCardiaque(Integer.parseInt(request.getParameter("rythmeCardiaque")));
            a.setMetres(1200);
            a.setMinutes(30);
            a.setDuree(30);
            a.setVitesse(12);
            a.setType("marche");
            a.setNombrePas(Integer.parseInt(request.getParameter("podometre")));
            a.setItineraire(itineraire);
            
            Utilisateur u = new Utilisateur();
            u.setId("5549fb695465be0984fb22db");
            Utilisateur utilisateur = gestionnaireUtilisateur.readUser(u);
            utilisateur.getActivites().add(a);
            
            gestionnaireUtilisateur.addActivite(utilisateur);
        }
    }
}
