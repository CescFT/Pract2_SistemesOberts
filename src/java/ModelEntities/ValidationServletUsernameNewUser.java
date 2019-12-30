package ModelEntities;

import AuthenticationModule.credentialsClient;
import ServicesSingleton.AutenticacioServiceSingleton;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class ValidationServletUsernameNewUser extends HttpServlet {
    
    private ServletContext context;
    private HashMap accounts = new HashMap();
    
    private void update(){
        AutenticacioServiceSingleton login = AutenticacioServiceSingleton.getInstance();
        Response res = login.getServeiAutenticacio().getAllClientsAutoritzats_JSON();
        List<credentialsClient> llistatClientsAutenticats = res.readEntity(new GenericType<List<credentialsClient>>(){});
        for(credentialsClient c : llistatClientsAutenticats)
        {
            accounts.put(c.getUsername(),c.getEmail());
            
        }
    }
    
    // Initialize the "accounts" hashmap. 
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.update();
        
    }
    
    public  void doGet(HttpServletRequest request, HttpServletResponse  response)
    throws IOException, ServletException {
        this.update();
        // Extract the data of the input form field whose name is "id"
        String targetId = request.getParameter("id");
        
        //  Send back either "<valid>true</valid>" or "<valid>false</valid>"
        //  XML message depending on the validity of the data that was entered.
        //  Note that the content type is "text/xml".
        //
        
        if((targetId != null) && !accounts.containsKey(targetId.trim()) && targetId.trim()!="") {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("<valid>true</valid>");
        } else {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("<valid>false</valid>");
        }
        
                
        
    }
    
    /*public  void doPost(HttpServletRequest request, HttpServletResponse  response)
    throws IOException, ServletException {
        
        String targetId = request.getParameter("passwdUser");
        if ((targetId != null) && !accounts.containsKey(targetId.trim())) {
            accounts.put(targetId.trim(), "account data");
            request.setAttribute("targetId", targetId);
            context.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }*/
    
}


