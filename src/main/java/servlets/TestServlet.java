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

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.setAttribute("utilisateur", "fabrice");
        this.getServletContext().getRequestDispatcher("/").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        System.out.println(request.getParameter("nom"));
        String params = request.getParameter("latitude");
        String paramsL = request.getParameter("longitude");
        System.out.println(params);
        this.getServletContext().getRequestDispatcher("/dashboard").forward(request, response);
    }
}
