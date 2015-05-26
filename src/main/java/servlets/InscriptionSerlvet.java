/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import gestionnaire.GestionnaireObjectif;
import gestionnaire.GestionnaireUtilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeles.Objectif;
import modeles.Utilisateur;

/**
 *
 * @author EK
 */
@WebServlet("/inscription")
public class InscriptionSerlvet extends HttpServlet {

    @EJB
    GestionnaireUtilisateur gestionnaireUtilisateur;
    @EJB
    GestionnaireObjectif gestionnaireObjectif;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InscriptionSerlvet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InscriptionSerlvet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = (request.getParameter("name")).trim();
        String naissance = (request.getParameter("naissance")).trim();
        String taille = (request.getParameter("taille")).trim();
        String poids = (request.getParameter("poids")).trim();
        String email = (request.getParameter("email")).trim();
        String motdepasse = (request.getParameter("motdepasse")).trim();
        String motdepasse2 = (request.getParameter("motdepasse2")).trim();
        String objectif = "S'entretenir";
        
        if (name==null || name.equals("")){
            request.setAttribute("error", "Veuillez spécifier un nom d'utilisateur.");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/inscription");
            rd.forward(request, response);
        }else{
            Utilisateur u = new Utilisateur();
            u.setEmail(email);
            
            if (gestionnaireUtilisateur.checkUser(u) !=null){
                request.setAttribute("error", "Email déjà utilisé");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/inscription");
                rd.forward(request, response);
            }else{
                u.setName(name);
                u.setMotdepasse(motdepasse);
                u.setPoids(poids);
                u.setTaille(taille);
                u.setNaissance(naissance);
                
                Objectif o =new Objectif();
                o.setId(objectif);
                u.setObjectif(gestionnaireObjectif.readObjectif(o));
                
                gestionnaireUtilisateur.createUser(u);
                
                request.setAttribute("succes", "Utilisateur inscrit avec succès !");
                
                List<Utilisateur> utilisateurs=gestionnaireUtilisateur.readAllUsers();
                request.setAttribute("utilisateurs", utilisateurs);
                
                List<Objectif> objectifs=gestionnaireObjectif.readAllObjectifs();
                request.setAttribute("objectifs", objectifs);
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard");
                rd.forward(request, response);
                
                
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
