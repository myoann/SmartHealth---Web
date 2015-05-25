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
import gestionnaire.GestionnaireObjectif;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import modeles.Objectif;
 
@WebServlet("/addUser")
@MultipartConfig
public class AddUserServlet extends HttpServlet {
 
    private static final long serialVersionUID = -7060758261496829905L;
    
    @EJB
    GestionnaireUtilisateur gestionnaireUtilisateur;
    @EJB
    GestionnaireObjectif gestionnaireObjectif;
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = getValue(request.getPart("name"));
        String email = getValue(request.getPart("email"));
        String motdepasse = getValue(request.getPart("motdepasse"));
        String poids = getValue(request.getPart("poids"));
        String taille = getValue(request.getPart("taille"));
        String naissance = getValue(request.getPart("naissance"));
        String objectif = getValue(request.getPart("objectif"));
        
        
        if ((name == null || name.equals(""))) {
            request.setAttribute("error", "Des paramètres sont manquants");
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionUtilisateur");
            rd.forward(request, response);
        } else {
            Utilisateur u = new Utilisateur();
            //u.setPhoto(photo);
            u.setEmail(email);
            if(gestionnaireUtilisateur.checkUser(u) != null) {
                request.setAttribute("error", "Email déjà utilisé");
                RequestDispatcher rd = getServletContext().getRequestDispatcher(
                        "/gestionUtilisateur");
                rd.forward(request, response);
            }
            else {
                u.setName(name);
                u.setMotdepasse(motdepasse);
                u.setPoids(poids);
                u.setTaille(taille);
                u.setNaissance(naissance);
                u.setMotdepasse(motdepasse);

                Objectif o = new Objectif();
                o.setId(objectif);
                u.setObjectif(gestionnaireObjectif.readObjectif(o));
                gestionnaireUtilisateur.createUser(u);
                System.out.println("Person Added Successfully with id="+u.getId());
                request.setAttribute("success", "Utilisateur ajouté avec succès");
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
    
    private static String getValue(Part part) throws IOException {
        if(part != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
            StringBuilder value = new StringBuilder();
            char[] buffer = new char[1024];
            for (int length = 0; (length = reader.read(buffer)) > 0;) {
                value.append(buffer, 0, length);
            }
            return value.toString();
        }
        else
            return null;
    }
 
}
