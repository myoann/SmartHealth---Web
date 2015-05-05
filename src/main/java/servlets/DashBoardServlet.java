/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import utilisateurs.modeles.Utilisateur;
import javax.servlet.http.HttpSession;
 
@WebServlet("/dashboard")
public class DashBoardServlet extends HttpServlet {
    public static final String ACCES_CONNEXION  = "/connexion";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String DASHBOARD        = "/user/dashBoard.jsp";
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if ( session.getAttribute(ATT_SESSION_USER) == null ) {
            /* Redirection vers la page publique */
            request.getRequestDispatcher(ACCES_CONNEXION).forward( request, response );
        } else {
            Utilisateur u = (Utilisateur) session.getAttribute( ATT_SESSION_USER );
            request.setAttribute("utilisateur", u);
            
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new java.util.Date(); 
            System.out.println(dateFormat.format(date));
                HashMap<String, Integer> nombrePasTotal = u.getNombrePas();
            
                for (Entry<String, Integer> entry : nombrePasTotal.entrySet()) {
                    if (entry.getKey().equals(dateFormat.format(date))) {
                        System.out.println(entry.getKey());
                        Integer nombrePas = entry.getValue();
                        request.setAttribute("nombrePas", nombrePas);
                    }
                }
            
            /* date 
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            request.setAttribute("date", dateFormat.format(cal.getTime()));
            */
            this.getServletContext().getRequestDispatcher(DASHBOARD).forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    public static <String, Integer> Set<String> getKeysByValue(Map<String, Integer> map, String value) {
       return map.entrySet()
                 .stream()
                 .filter(entry -> Objects.equals(entry.getKey(), value))
                 .map(Map.Entry::getKey)
                 .collect(Collectors.toSet());
   }
}