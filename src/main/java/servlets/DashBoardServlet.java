/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mongodb.MongoClient;
import gestionnaire.GestionnaireObjectif;
import gestionnaire.GestionnaireUtilisateur;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.EJB;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import modeles.Utilisateur;
import javax.servlet.http.HttpSession;
import modeles.Activite;
import modeles.Objectif;
import org.json.JSONArray;
 
@WebServlet("/dashboard")
public class DashBoardServlet extends HttpServlet {
    public static final String ACCES_CONNEXION  = "/connexion";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String DASHBOARD        = "/user/dashBoard.jsp";
 
    @EJB
    GestionnaireObjectif gestionnaireObjectif;
    @EJB
    GestionnaireUtilisateur gestionnaireUtilisateur;
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if ( session.getAttribute(ATT_SESSION_USER) == null ) {
            /* Redirection vers la page publique */
            request.getRequestDispatcher(ACCES_CONNEXION).forward( request, response );
        } else {
            Utilisateur u = (Utilisateur) session.getAttribute( ATT_SESSION_USER );
            
            Utilisateur utilisateur = gestionnaireUtilisateur.readUser(u);
            request.setAttribute("utilisateur", utilisateur);
            
            List<Objectif> objectifs = gestionnaireObjectif.readAllObjectifs();
            request.setAttribute("objectifs", objectifs);
            
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dateJour = new java.util.Date();
            request.setAttribute("date", dateFormat.format(dateJour));
            
            Date date;
            Activite a = new Activite();
            try {
                date = dateFormat.parse("24/05/2015");
                a.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[][] itineraire= {{"43.6980876","43.6980876","43.6980876","43.6980876"},{"7.215362199999999","7.225365199999999","7.235372199999999","7.255375199999999"}};
            a.setFrequenceCardiaque(60);
            a.setNombrePas(1500);
            a.setMetres(1200);
            a.setMinutes(30);
            a.setVitesse(12);
            a.setType("marche");
            a.setItineraire(itineraire);
            utilisateur.getActivites().add(a);
            
            
            Date dateb;
            Activite b = new Activite();
            try {
                dateb = dateFormat.parse("25/05/2015");
                b.setDate(dateb);
            } catch (ParseException ex) {
                Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[][] itineraireb= {{"43.6980876","43.6980876","43.6980876","43.6980876"},{"7.215362199999999","7.225365199999999","7.235372199999999","7.255375199999999"}};
            b.setFrequenceCardiaque(30);
            b.setNombrePas(1800);
            b.setMetres(1200);
            b.setMinutes(30);
            b.setVitesse(12);
            b.setType("marche");
            b.setItineraire(itineraireb);
            utilisateur.getActivites().add(b);
            
            Date datec;
            Activite c = new Activite();
            try {
                datec = dateFormat.parse("25/05/2015");
                c.setDate(datec);
            } catch (ParseException ex) {
                Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[][] itinerairec= {{"43.7980876","43.7980876","43.7980876","43.7980876"},{"7.315362199999999","7.325365199999999","7.335372199999999","7.355375199999999"}};
            c.setFrequenceCardiaque(45);
            c.setNombrePas(1800);
            c.setMetres(1200);
            c.setMinutes(30);
            c.setVitesse(12);
            c.setType("marche");
            c.setItineraire(itinerairec);
            utilisateur.getActivites().add(c);
            
            
            int nombrePas = 0;
            int nombreMinutes = 0;
            int nombreMetres = 0;
            String jourS = "";
            String pasParJourS = "";
            String minutesParJourS = "";
            String metreParJourS = "";
            String freqCardiaqueS = "";
            String latitudeS = "";
            String longitudeS = "";
            ArrayList<String> jour = new ArrayList<>();
            ArrayList<Integer> pasParJour = new ArrayList<>();
            ArrayList<Integer> minutesParJour = new ArrayList<>();
            ArrayList<Integer> metreParJour = new ArrayList<>();
            ArrayList<Integer> freqCardiaqueParJour = new ArrayList<>();
            ArrayList<Integer> activiteParJour = new ArrayList<>();
            ArrayList<String> latitudeParJour = new ArrayList<>();
            ArrayList<String> longitudeParJour = new ArrayList<>();
            if(!utilisateur.getActivites().isEmpty()) {
                ArrayList<Activite> activites = utilisateur.getActivites();
                for(int i=0; i<activites.size(); i++) {
                    if(i > 0 && dateFormat.format(activites.get(i).getDate()).equals(dateFormat.format(activites.get(i-1).getDate()))){
                        pasParJour.set(pasParJour.size()-1, pasParJour.get(pasParJour.size()-1)+activites.get(i).getNombrePas());
                        minutesParJour.set(minutesParJour.size()-1, minutesParJour.get(minutesParJour.size()-1)+activites.get(i).getMinutes());
                        metreParJour.set(metreParJour.size()-1, metreParJour.get(metreParJour.size()-1)+activites.get(i).getMetres());
                        activiteParJour.set(activiteParJour.size()-1, activiteParJour.get(pasParJour.size()-1)+1);
                        String[][] latLngTab = activites.get(i).getItineraire();
                        
                        for(int indice = 0; indice < latLngTab[0].length; indice++)
                        {
                            if(indice == 0) {
                              latitudeParJour.set(latitudeParJour.size()-1, latitudeParJour.get(latitudeParJour.size()-1)+"/"+latLngTab[0][indice]);
                              longitudeParJour.set(longitudeParJour.size()-1, longitudeParJour.get(longitudeParJour.size()-1)+"/"+latLngTab[1][indice]);
                            }
                            else {
                              latitudeParJour.set(latitudeParJour.size()-1, latitudeParJour.get(latitudeParJour.size()-1)+","+latLngTab[0][indice]);
                              longitudeParJour.set(longitudeParJour.size()-1, longitudeParJour.get(longitudeParJour.size()-1)+","+latLngTab[1][indice]);
                            }
                        }
                        
                    }
                    else {
                        jour.add(dateFormat.format(activites.get(i).getDate()));
                        pasParJour.add(activites.get(i).getNombrePas());
                        minutesParJour.add(activites.get(i).getMinutes());
                        metreParJour.add(activites.get(i).getMetres());
                        freqCardiaqueParJour.add(activites.get(i).getFrequenceCardiaque());
                        String[][] latLngTab = activites.get(i).getItineraire();
                        
                        for(int indice = 0; indice < latLngTab[0].length; indice++)
                        {
                            if(indice == 0) {
                                latitudeParJour.add(latLngTab[0][indice]);
                                longitudeParJour.add(latLngTab[1][indice]);
                            }
                            else {
                                latitudeParJour.set(latitudeParJour.size()-1, latitudeParJour.get(latitudeParJour.size()-1)+","+latLngTab[0][indice]);
                                longitudeParJour.set(longitudeParJour.size()-1, longitudeParJour.get(longitudeParJour.size()-1)+","+latLngTab[1][indice]);
                            }
                        }
                        activiteParJour.add(1);
                    }
                }
                for(int i=0; i<jour.size(); i++) {
                    if (jour.get(i).equals(dateFormat.format(dateJour))) {
                        nombrePas = pasParJour.get(i);
                        nombreMinutes = minutesParJour.get(i);
                        nombreMetres = metreParJour.get(i);
                        latitudeS = latitudeParJour.get(i);
                        longitudeS = longitudeParJour.get(i);
                    }
                    jourS += jour.get(i)+",";
                    pasParJourS += pasParJour.get(i)+",";
                    minutesParJourS += minutesParJour.get(i)+",";
                    metreParJourS += metreParJour.get(i)+",";
                    freqCardiaqueS += (freqCardiaqueParJour.get(i)/activiteParJour.get(i))+",";
                }
            }
            jourS = jourS.substring(0, jourS.length()-1);
            pasParJourS = pasParJourS.substring(0, pasParJourS.length()-1);
            minutesParJourS = minutesParJourS.substring(0, minutesParJourS.length()-1);
            metreParJourS = metreParJourS.substring(0, metreParJourS.length()-1);
            freqCardiaqueS = freqCardiaqueS.substring(0, freqCardiaqueS.length()-1);
            request.setAttribute("activiteJour", jourS);
            request.setAttribute("pasParJour", pasParJourS);
            request.setAttribute("minutesParJour", minutesParJourS);
            request.setAttribute("metresParJour", metreParJourS);
            request.setAttribute("freqCardiaque", freqCardiaqueS);
            request.setAttribute("latitude", latitudeS);
            request.setAttribute("longitude", longitudeS);
            
            request.setAttribute("nombrePas", nombrePas);
            request.setAttribute("nombreMinutes", nombreMinutes);
            request.setAttribute("nombreMetres", nombreMetres);
            
            Date time = new Date();
            DateFormat dfl = DateFormat.getDateInstance(DateFormat.FULL);
            request.setAttribute("date", dfl.format(time));
            
            this.getServletContext().getRequestDispatcher(DASHBOARD).forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}