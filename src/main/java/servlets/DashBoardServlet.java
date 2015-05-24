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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.ejb.EJB;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import modeles.Utilisateur;
import javax.servlet.http.HttpSession;
import modeles.Objectif;
 
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
            Date date = new java.util.Date();
            /*
            HashMap<String, Integer> nombrePasTotal = u.getNombrePas();
            
            request.setAttribute("date", dateFormat.format(date));
            
            for (Entry<String, Integer> entry : nombrePasTotal.entrySet()) {
                if (entry.getKey().equals(dateFormat.format(date))) {
                    System.out.println(entry.getKey());
                    Integer nombrePas = entry.getValue();
                    request.setAttribute("nombrePas", nombrePas);
                }
                else
                    request.setAttribute("nombrePas", 500);
            }
            
            HashMap<String, Integer> nombreMinutesTotal = u.getMinutes();
            
            for (Entry<String, Integer> entry : nombreMinutesTotal.entrySet()) {
                if (entry.getKey().equals(dateFormat.format(date))) {
                    System.out.println(entry.getKey());
                    Integer nombreMinutes = entry.getValue();
                    request.setAttribute("nombreMinutes", nombreMinutes);
                }
                else
                    request.setAttribute("nombreMinutes", 30);
            }
            
            HashMap<String, Integer> nombreMetresTotal = u.getMetres();
            
            for (Entry<String, Integer> entry : nombreMetresTotal.entrySet()) {
                if (entry.getKey().equals(dateFormat.format(date))) {
                    System.out.println(entry.getKey());
                    Integer nombreMetres = entry.getValue();
                    request.setAttribute("nombreMetres", nombreMetres);
                }
                else
                    request.setAttribute("nombreMetres", 300);
            }
            */
            /* date 
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            request.setAttribute("date", dateFormat.format(cal.getTime()));
            */
            this.getServletContext().getRequestDispatcher(DASHBOARD).forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}