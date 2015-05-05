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
import modeles.Objectif;
 
@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
 
    private static final long serialVersionUID = -6554920927964049383L;
    
    @EJB
    GestionnaireUtilisateur gestionnaireUtilisateur;
    @EJB
    GestionnaireObjectif gestionnaireObjectif;
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
        System.out.println("Person edit requested with id=" + id);
        Utilisateur u = new Utilisateur();
        u.setId(id);
        u = gestionnaireUtilisateur.readUser(u);
        request.setAttribute("utilisateur", u);
        List<Utilisateur> utilisateurs = gestionnaireUtilisateur.readAllUsers();
        request.setAttribute("utilisateurs", utilisateurs);
        
        List<Objectif> objectifs = gestionnaireObjectif.readAllObjectifs();
        request.setAttribute("objectifs", objectifs);
 
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionUtilisateur");
        rd.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id"); // keep it non-editable in UI
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
 
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
            request.setAttribute("error", "Name and Country Can't be empty");
            Utilisateur u = new Utilisateur();
            u.setId(id);
            u.setCountry(country);
            u.setName(name);
            u.setEmail(email);
            u.setMotdepasse(motdepasse);
            u.setPoids(poids);
            u.setTaille(taille);
            u.setNaissance(naissance);
            u.setMotdepasse(motdepasse);
            
            Objectif o = new Objectif();
            o.setId(objectif);
            u.setObjectif(gestionnaireObjectif.readObjectif(o));
            request.setAttribute("utilisateur", u);
            List<Utilisateur> utilisateurs = gestionnaireUtilisateur.readAllUsers();
            request.setAttribute("utilisateurs", utilisateurs);
            
            List<Objectif> objectifs = gestionnaireObjectif.readAllObjectifs();
            request.setAttribute("objectifs", objectifs);
 
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionUtilisateur");
            rd.forward(request, response);
        } else {
            Utilisateur u = new Utilisateur();
            u.setId(id);
            u.setCountry(country);
            u.setName(name);
            u.setEmail(email);
            u.setMotdepasse(motdepasse);
            u.setPoids(poids);
            u.setTaille(taille);
            u.setNaissance(naissance);
            u.setMotdepasse(motdepasse);
            
            Objectif o = new Objectif();
            o.setId(objectif);
            u.setObjectif(gestionnaireObjectif.readObjectif(o));
            gestionnaireUtilisateur.updateUser(u);
            System.out.println("Person edited successfully with id=" + id);
            request.setAttribute("success", "Person edited successfully");
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
