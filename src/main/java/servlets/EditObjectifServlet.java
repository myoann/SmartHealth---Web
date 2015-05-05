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
import javax.ejb.EJB;
import modeles.Objectif;
 
@WebServlet("/editObjectif")
public class EditObjectifServlet extends HttpServlet {
 
    @EJB
    GestionnaireObjectif gestionnaireObjectif;
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
        System.out.println("Objectif edit requested with id=" + id);
        Objectif o = new Objectif();
        o.setId(id);
        o = gestionnaireObjectif.readObjectif(o);
        request.setAttribute("objectif", o);
        List<Objectif> objectifs = gestionnaireObjectif.readAllObjectifs();
        request.setAttribute("objectifs", objectifs);
 
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionObjectif");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id"); // keep it non-editable in UI
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
        
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
            request.setAttribute("error", "Titre and Description Can't be empty");
            Objectif o = new Objectif();
            o.setId(id);
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
            request.setAttribute("objectif", o);
            List<Objectif> objectifs = gestionnaireObjectif.readAllObjectifs();
            request.setAttribute("objectifs", objectifs);
 
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionObjectif");
            rd.forward(request, response);
        } else {
            Objectif o = new Objectif();
            o.setId(id);
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
            gestionnaireObjectif.updateObjectif(o);
            System.out.println("Objectif edited successfully with id=" + id);
            request.setAttribute("success", "Objectif edited successfully");
            List<Objectif> objectifs = gestionnaireObjectif.readAllObjectifs();
            request.setAttribute("objectifs", objectifs);
 
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/gestionObjectif");
            rd.forward(request, response);
        }
    }
 
}
