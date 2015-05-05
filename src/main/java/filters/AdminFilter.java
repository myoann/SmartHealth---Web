/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import com.mongodb.MongoClient;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import gestionnaire.GestionnaireUtilisateur;
import javax.ejb.EJB;
import modeles.Utilisateur;

public class AdminFilter implements Filter {
    public static final String ACCES_CONNEXION  = "/connexion";
    public static final String DASHBOARD  = "/dashboard";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    @EJB
    private GestionnaireUtilisateur gestionnaireUtilisateur;
    
    public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {
        /* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute( ATT_SESSION_USER );
        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( utilisateur == null ) {
            /* Redirection vers la page publique */
            request.getRequestDispatcher(ACCES_CONNEXION).forward( request, response );
        } else {
            /* Affichage de la page restreinte */
           
            Utilisateur u = gestionnaireUtilisateur.checkUser(utilisateur);
            u.setAdmin(true);
            if (u != null && u.isAdmin() == true) {
                chain.doFilter( request, response );
            }
            else {
                request.getRequestDispatcher(DASHBOARD).forward( request, response );
            }
        }
    }

    public void destroy() {
    }
}
