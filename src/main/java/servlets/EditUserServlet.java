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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import modeles.Objectif;
 
@WebServlet("/editUser")
@MultipartConfig
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
        String id = getValue(request.getPart("id"));
        System.out.println("id = "+id);
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
        
        String name = getValue(request.getPart("name"));
        String email = getValue(request.getPart("email"));
        String motdepasse = getValue(request.getPart("motdepasse"));
        String poids = getValue(request.getPart("poids"));
        String taille = getValue(request.getPart("taille"));
        String naissance = getValue(request.getPart("naissance"));
        String objectif = getValue(request.getPart("objectif"));
        String type = getValue(request.getPart("type"));
        
        /*
        Part part = request.getPart("photo");
        String nomPhoto = getNomFichier(part);
        if ( nomPhoto != null && !nomPhoto.isEmpty() ) {
            String nomChamp = part.getName();
            nomPhoto = nomPhoto.substring( nomPhoto.lastIndexOf( '/' ) + 1 )
                    .substring( nomPhoto.lastIndexOf( '\\' ) + 1 );
            String relativeWebPath = "data"+File.separator+"user"+File.separator;
            ServletContext servletContext = getServletContext();
            String path = servletContext.getRealPath(File.separator)+relativeWebPath;
            System.out.print(path);
            ecrireFichier(part, path+nomPhoto);
            request.setAttribute(nomChamp, nomPhoto );
        }
        */
        if ((name == null || name.equals("")) && type == null) {
            request.setAttribute("error", "Nom ne peut pas être vide");
            Utilisateur u = new Utilisateur();
            u.setId(id);
            /*
            u.setPhoto(nomPhoto);
            */
            u.setName(name);
            u.setEmail(email);
            u.setMotdepasse(motdepasse);
            u.setPoids(poids);
            u.setTaille(taille);
            u.setNaissance(naissance);
            u.setMotdepasse(motdepasse);
            
            if(objectif != null) {
                Objectif o = new Objectif();
                o.setId(objectif);
                u.setObjectif(gestionnaireObjectif.readObjectif(o));
            }
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
            /*
            u.setPhoto(nomPhoto);
            */
            u.setName(name);
            u.setEmail(email);
            u.setMotdepasse(motdepasse);
            u.setPoids(poids);
            u.setTaille(taille);
            u.setNaissance(naissance);
            
            if(objectif != null) {
                Objectif o = new Objectif();
                o.setId(objectif);
                u.setObjectif(gestionnaireObjectif.readObjectif(o));
            }
            
            if(type != null && type.equals("modifierProfil")) {
                gestionnaireUtilisateur.updateProfil(u);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(
                        "/dashboard");
                rd.forward(request, response);
            }
            else if(type != null && type.equals("modifierDonnees")) {
                gestionnaireUtilisateur.updateDonnees(u); 
                RequestDispatcher rd = getServletContext().getRequestDispatcher(
                        "/dashboard");
                rd.forward(request, response);
            }
            else if(type != null && type.equals("modifierObjectif")) {
                gestionnaireUtilisateur.updateObjectif(u);   
                RequestDispatcher rd = getServletContext().getRequestDispatcher(
                        "/dashboard");
                rd.forward(request, response);
            }
            else {
                gestionnaireUtilisateur.updateUser(u);
                System.out.println("Person edited successfully with id=" + id);
                request.setAttribute("success", "Utilisateur édité avec succès");
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
    /*
    private void ecrireFichier(Part part, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;

        entree = new BufferedInputStream(part.getInputStream(), 10240);
        System.out.println(chemin);
        File photo = new File(chemin);
        if(!photo.exists()) {
            photo.createNewFile();
        }
        sortie = new BufferedOutputStream(new FileOutputStream(photo, false), 10240 );

        byte[] tampon = new byte[10240];
        int longueur;
        while ( ( longueur = entree.read( tampon ) ) > 0 ) {
            sortie.write( tampon, 0, longueur );
        }
        sortie.close();
        entree.close();
    }
    private static String getNomFichier( Part part ) {
        if(part != null) {
            for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
                if ( contentDisposition.trim().startsWith( "filename" ) ) {
                    return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
                }
            }
            return null;
        }
        else
            return null;
    }
    */
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
