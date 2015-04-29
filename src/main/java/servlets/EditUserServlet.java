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
 
@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
 
    private static final long serialVersionUID = -6554920927964049383L;
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
        System.out.println("Person edit requested with id=" + id);
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        GestionnaireUtilisateur userDAO = new GestionnaireUtilisateur(mongo);
        Utilisateur u = new Utilisateur();
        u.setId(id);
        u = userDAO.readUser(u);
        request.setAttribute("person", u);
        List<Utilisateur> utilisateurs = userDAO.readAllUsers();
        request.setAttribute("persons", utilisateurs);
 
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/persons.jsp");
        rd.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id"); // keep it non-editable in UI
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
 
        String name = request.getParameter("name");
        String country = request.getParameter("country");
 
        if ((name == null || name.equals(""))
                || (country == null || country.equals(""))) {
            request.setAttribute("error", "Name and Country Can't be empty");
            MongoClient mongo = (MongoClient) request.getServletContext()
                    .getAttribute("MONGO_CLIENT");
            GestionnaireUtilisateur userDAO = new GestionnaireUtilisateur(mongo);
            Utilisateur u = new Utilisateur();
            u.setId(id);
            u.setName(name);
            u.setCountry(country);
            request.setAttribute("person", u);
            List<Utilisateur> utilisateurs = userDAO.readAllUsers();
            request.setAttribute("persons", utilisateurs);
 
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/persons.jsp");
            rd.forward(request, response);
        } else {
            MongoClient mongo = (MongoClient) request.getServletContext()
                    .getAttribute("MONGO_CLIENT");
            GestionnaireUtilisateur userDAO = new GestionnaireUtilisateur(mongo);
            Utilisateur u = new Utilisateur();
            u.setId(id);
            u.setName(name);
            u.setCountry(country);
            userDAO.updateUser(u);
            System.out.println("Person edited successfully with id=" + id);
            request.setAttribute("success", "Person edited successfully");
            List<Utilisateur> utilisateurs = userDAO.readAllUsers();
            request.setAttribute("persons", utilisateurs);
 
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/persons.jsp");
            rd.forward(request, response);
        }
    }
 
}
