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
 
import com.mongodb.MongoClient;
import gestionnaire.GestionnaireObjectif;
import gestionnaire.GestionnaireUtilisateur;
import javax.ejb.EJB;
import modeles.Objectif;
 
@WebServlet("/addObjectif")
public class AddObjectifServlet extends HttpServlet {
 
    private static final long serialVersionUID = -7060758261496829905L;
 
    @EJB
    GestionnaireObjectif gestionnaireObjectif;
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        Integer nombrePas = Integer.parseInt(request.getParameter("nombrePas"));
        Integer minutes = Integer.parseInt(request.getParameter("minutes"));
        Integer metres = Integer.parseInt(request.getParameter("metres"));
        Integer veloMetres = Integer.parseInt(request.getParameter("veloMetres"));
        Integer veloTemps = Integer.parseInt(request.getParameter("veloTemps"));
        Integer marcheMetres = Integer.parseInt(request.getParameter("marcheMetres"));
        Integer marcheTemps = Integer.parseInt(request.getParameter("marcheTemps"));
        Integer courseMetres = Integer.parseInt(request.getParameter("courseMetres"));
        Integer courseTemps = Integer.parseInt(request.getParameter("courseTemps"));
        
        if ((titre == null || titre.equals(""))
                || (description == null || description.equals(""))) {
            request.setAttribute("error", "Mandatory Parameters Missing");
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionObjectif");
            rd.forward(request, response);
        } else {
            Objectif o = new Objectif();
            o.setTitre(titre);
            o.setDescription(description);
            o.setNombrePas(nombrePas);
            o.setMinutes(minutes);
            o.setMetres(metres);
            o.setVeloMetres(veloMetres);
            o.setVeloTemps(veloTemps);
            o.setMarcheMetres(marcheMetres);
            o.setMarcheTemps(marcheTemps);
            o.setCourseMetres(courseMetres);
            o.setCourseTemps(courseTemps);
            gestionnaireObjectif.createObjectif(o);
            System.out.println("Objectif Added Successfully with id="+o.getId());
            request.setAttribute("success", "Objectif ajouté avec succès");
            List<Objectif> objectifs = gestionnaireObjectif.readAllObjectifs();
            request.setAttribute("objectifs", objectifs);
 
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionObjectif");
            rd.forward(request, response);
        }
    }
 
}
