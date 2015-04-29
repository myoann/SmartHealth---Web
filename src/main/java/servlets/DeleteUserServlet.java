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
 
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
 
    private static final long serialVersionUID = 6798036766148281767L;
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for delete operation");
        }
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        GestionnaireUtilisateur userDAO = new GestionnaireUtilisateur(mongo);
        Utilisateur u = new Utilisateur();
        u.setId(id);
        userDAO.deleteUser(u);
        System.out.println("Person deleted successfully with id=" + id);
        request.setAttribute("success", "Person deleted successfully");
        List<Utilisateur> utilisateurs = userDAO.readAllUsers();
        request.setAttribute("persons", utilisateurs);
 
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/persons.jsp");
        rd.forward(request, response);
    }
 
}