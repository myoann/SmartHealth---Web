/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mongodb.MongoClient;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeles.Utilisateur;
import forms.ConnexionForm;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.annotation.WebServlet;
import gestionnaire.GestionnaireUtilisateur;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.ServletInputStream;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        response.setContentType("application/json");
        System.out.println("Dans le doGet");

        if(request.getParameter("useFunctionServer").equals("getProfil")){
            PrintWriter out = response.getWriter();
            //les valeurs doivent être reprisent de la classe utilisateurs.modeles.utilisateur.java
            out.print("{"
                    + "\"mail\": \"fjauvat@gmail.com\","
                    + "\"dateNaissance\": \"28/04/1991\","
                    +"\"taille\":\"187\","
                    +"\"poids\":\"85\""
                    + "}");
        }
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        System.out.println("Dans le doPost");
        if(request.getParameter("useFunctionServer").equals("modificationProfil")){
            System.out.println(request.getParameter("userId"));
            System.out.println(request.getParameter("dateDuJour"));
            System.out.println(request.getParameter("userEmail"));
            System.out.println(request.getParameter("userDateNaissance"));
            System.out.println(request.getParameter("userPoids"));
            System.out.println(request.getParameter("userTaille"));
        }
        else{
            System.out.println(request.getParameter("nom"));
            System.out.println(request.getParameter("latitude"));
            System.out.println(request.getParameter("longitude"));
        }
        this.getServletContext().getRequestDispatcher("/").forward(request, response);
    }
}
