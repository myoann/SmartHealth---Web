/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import gestionnaire.GestionnaireUtilisateur;
import modeles.Utilisateur;
import com.mongodb.MongoClient;
import gestionnaire.GestionnaireObjectif;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import modeles.Objectif;
 
@WebServlet("/gestionUtilisateur")
public class GestionUtilisateurServlet extends HttpServlet {
    
    public static final String ACCES_CONNEXION  = "/connexion";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String DASHBOARD        = "/user/dashBoard.jsp";
 
    @EJB
    GestionnaireUtilisateur gestionnaireUtilisateur;
    @EJB
    GestionnaireObjectif gestionnaireObjectif;
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute( ATT_SESSION_USER );
        
        if ( utilisateur == null ) {
            request.getRequestDispatcher(ACCES_CONNEXION).forward( request, response );
        } else {
            Utilisateur u = gestionnaireUtilisateur.checkUser(utilisateur);
            u.setAdmin(true);
            if (u != null && u.isAdmin() == true) {
                List<Objectif> objectifs = gestionnaireObjectif.readAllObjectifs();
                request.setAttribute("objectifs", objectifs);
                List<Utilisateur> utilisateurs = gestionnaireUtilisateur.readAllUsers();
                request.setAttribute("utilisateurs", utilisateurs);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(
                        "/admin/gestionUtilisateur.jsp");
                rd.forward(request, response);
            }
            else {
                request.getRequestDispatcher(DASHBOARD).forward( request, response );
            }
        }
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
 
}
