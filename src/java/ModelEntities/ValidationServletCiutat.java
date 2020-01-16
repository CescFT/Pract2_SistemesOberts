package ModelEntities;

import AuthenticationModule.credentialsClient;
import ServicesSingleton.AutenticacioServiceSingleton;
import ServicesSingleton.RoomServiceSingleton;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class ValidationServletCiutat extends HttpServlet {

    private ServletContext context;
    private HashMap ciutats = new HashMap();

    private String majusPrimeraLletra(String a){
        char[] aArray = a.toCharArray();
        String primeraLletra = String.valueOf(aArray[0]).toUpperCase();
        String resultat = a.replace(a.substring(0), primeraLletra);
        resultat = resultat + a.substring(1, a.length());
        return resultat;
    }
    
    private void update() {
        RoomServiceSingleton r = RoomServiceSingleton.getInstance();
        Response res = r.getService().findAllHabtacions("desc");
        List<Habitacio> llistatHabitacionsDisp = res.readEntity(new GenericType<List<Habitacio>>() {
        });
        for (Habitacio hab : llistatHabitacionsDisp) {
            ciutats.put(hab.getNomHabitacio(), hab.getCiutat());

        }
    }

    // Initialize the "ciutats" hashmap. 
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.update();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        this.update();
        // Extract the data of the input form field whose name is "id"
        String targetId = request.getParameter("ciutat");

        //  Send back either "<valid>true</valid>" or "<valid>false</valid>"
        //  XML message depending on the validity of the data that was entered.
        //  Note that the content type is "text/xml".
        //
        if (targetId != null) {
            if (!targetId.trim().equals("")) {
                List<String> ciutatsTrobades = new ArrayList<String>();
                for (Object ciutat : ciutats.values()) {
                    if (String.valueOf(ciutat).contains(targetId.trim().toLowerCase()) && !ciutatsTrobades.contains(ciutat)) {
                        ciutatsTrobades.add(String.valueOf(ciutat));
                    }
                }

                if (!ciutatsTrobades.isEmpty()) {
                    String ciutats = "";
                    for (String ciutat : ciutatsTrobades) {
                        String ciutatOk = this.majusPrimeraLletra(ciutat);
                        ciutats += ciutatOk + ";";
                    }
                    response.setContentType("text/xml");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getWriter().write("<valid>" + ciutats + "</valid>");
                } else {
                    response.setContentType("text/xml");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getWriter().write("<valid>false</valid>");
                }
            } else {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<valid> </valid>");
            }

        } else {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("<valid>false</valid>");
        }
    }

    /*public  void doPost(HttpServletRequest request, HttpServletResponse  response)
    throws IOException, ServletException {
        
        String targetId = request.getParameter("passwdUser");
        if ((targetId != null) && !ciutats.containsKey(targetId.trim())) {
            ciutats.put(targetId.trim(), "account data");
            request.setAttribute("targetId", targetId);
            context.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }*/
}
