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
 
import utilisateurs.gestionnaire.GestionnaireUtilisateur;
import utilisateurs.modeles.Utilisateur;
import com.mongodb.MongoClient;
import java.util.HashMap;
 
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
 
    private static final long serialVersionUID = -7060758261496829905L;
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String motdepasse = request.getParameter("motdepasse");
        String poids = request.getParameter("poids");
        String taille = request.getParameter("taille");
        String naissance = request.getParameter("naissance");
        if ((name == null || name.equals(""))
                || (country == null || country.equals(""))) {
            request.setAttribute("error", "Mandatory Parameters Missing");
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionUtilisateur");
            rd.forward(request, response);
        } else {
            Utilisateur u = new Utilisateur();
            u.setCountry(country);
            u.setName(name);
            u.setEmail(email);
            u.setMotdepasse(motdepasse);
            u.setPoids(poids);
            u.setTaille(taille);
            u.setNaissance(naissance);
            u.setMotdepasse(motdepasse);
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            map.put("10/02/2015", 1500);
            map.put("11/02/2015", 1300);
            map.put("12/02/2015", 1800);
            map.put("30/04/2015", 1800);
            u.setNombrePas(map);
            u.setMetres(map);
            u.setMinutes(map);
            MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
            GestionnaireUtilisateur userDAO = new GestionnaireUtilisateur(mongo);
            userDAO.createUser(u);
            System.out.println("Person Added Successfully with id="+u.getId());
            request.setAttribute("success", "Person Added Successfully");
            List<Utilisateur> utilisateurs = userDAO.readAllUsers();
            request.setAttribute("utilisateurs", utilisateurs);
 
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionUtilisateur");
            rd.forward(request, response);
        }
    }
 
}
