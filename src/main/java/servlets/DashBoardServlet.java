/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mongodb.MongoClient;
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import utilisateurs.modeles.Utilisateur;
import javax.servlet.http.HttpSession;
 
@WebServlet("/dashboard")
public class DashBoardServlet extends HttpServlet {
    public static final String ACCES_CONNEXION  = "/connexion";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
 
    private static final long serialVersionUID = 6798036766148281767L;
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        Utilisateur u = (Utilisateur) session.getAttribute( ATT_SESSION_USER );
        request.setAttribute("utilisateur", u);
        this.getServletContext().getRequestDispatcher("/user/dashBoard.jsp").forward(request, response);
    }
 
}