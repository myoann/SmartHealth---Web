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
import java.util.HashMap;
import javax.ejb.EJB;
import modeles.Objectif;
 
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
 
    private static final long serialVersionUID = -7060758261496829905L;
    
    @EJB
    GestionnaireUtilisateur gestionnaireUtilisateur;
    @EJB
    GestionnaireObjectif gestionnaireObjectif;
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String motdepasse = request.getParameter("motdepasse");
        String poids = request.getParameter("poids");
        String taille = request.getParameter("taille");
        String naissance = request.getParameter("naissance");
        String objectif = request.getParameter("objectif");
        
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
            
            Objectif o = new Objectif();
            o.setId(objectif);
            u.setObjectif(gestionnaireObjectif.readObjectif(o));
            gestionnaireUtilisateur.createUser(u);
            System.out.println("Person Added Successfully with id="+u.getId());
            request.setAttribute("success", "Person Added Successfully");
            List<Utilisateur> utilisateurs = gestionnaireUtilisateur.readAllUsers();
            request.setAttribute("utilisateurs", utilisateurs);
            
            List<Objectif> objectifs = gestionnaireObjectif.readAllObjectifs();
            request.setAttribute("objectifs", objectifs);
 
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionUtilisateur");
            rd.forward(request, response);
        }
    }
 
}
