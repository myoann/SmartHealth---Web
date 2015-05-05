/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mongodb.MongoClient;
import gestionnaire.GestionnaireObjectif;
import javax.ejb.EJB;
import modeles.Objectif;
 
@WebServlet("/deleteObjectif")
public class DeleteObjectifServlet extends HttpServlet {
 
    @EJB
    GestionnaireObjectif gestionnaireObjectif;
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for delete operation");
        }
        Objectif o = new Objectif();
        o.setId(id);
        gestionnaireObjectif.deleteObjectif(o);
        System.out.println("Objectif deleted successfully with id=" + id);
        request.setAttribute("success", "Objectif deleted successfully");
 
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionObjectif");
        rd.forward(request, response);
    }
 
}