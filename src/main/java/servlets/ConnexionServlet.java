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

import utilisateurs.modeles.Utilisateur;
import forms.ConnexionForm;
import utilisateurs.gestionnaire.GestionnaireUtilisateur;

public class ConnexionServlet extends HttpServlet {
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/connexion.jsp";
    public static final String DASHBOARD        = "/user/dashBoard.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        if (session.getAttribute(ATT_SESSION_USER) != null ) {
            /* Redirection vers la page publique */
            request.getRequestDispatcher(DASHBOARD).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.connecterUtilisateur(request);

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
             MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
            GestionnaireUtilisateur userDAO = new GestionnaireUtilisateur(mongo);
            Utilisateur u = userDAO.checkUser(utilisateur);
            if (u != null && u.getMotdepasse().equals(utilisateur.getMotdepasse())) {
                session.setAttribute(ATT_SESSION_USER, u);
                form.setResultat("Succès de la connexion.");
                this.getServletContext().getRequestDispatcher(DASHBOARD).forward(request, response);
                
            } else {
                session.setAttribute(ATT_SESSION_USER, null );
                form.setResultat("Échec de la connexion.");
            }
        } else {
            session.setAttribute(ATT_SESSION_USER, null );
            form.setResultat("Échec de la connexion.");
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form );
        request.setAttribute(ATT_USER, utilisateur );

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
