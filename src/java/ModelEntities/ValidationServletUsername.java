package ModelEntities;

import AuthenticationModule.credentialsClient;
import ServicesSingleton.AutenticacioServiceSingleton;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class ValidationServletUsername extends HttpServlet {
    
    private ServletContext context;
    private HashMap accounts = new HashMap();
    
    private void update(){
        AutenticacioServiceSingleton login = AutenticacioServiceSingleton.getInstance();
        Response res = login.getServeiAutenticacio().getAllClientsAutoritzats_JSON();
        List<credentialsClient> llistatClientsAutenticats = res.readEntity(new GenericType<List<credentialsClient>>(){});
        for(credentialsClient c : llistatClientsAutenticats)
        {
            accounts.put(c.getUsername(),c.getPassword());
            
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
        boolean trobat = false;
        // Extract the data of the input form field whose name is "id"
        String targetId = request.getParameter("id");
        String passwd = request.getParameter("passwd");
        
        //  Send back either "<valid>true</valid>" or "<valid>false</valid>"
        //  XML message depending on the validity of the data that was entered.
        //  Note that the content type is "text/xml".
        //
        
        if((targetId != null) && (passwd != null)) {
            System.out.println(":: contrassenya que tinc: "+accounts.get(targetId.trim()));
            System.out.println(":: contrassenya que em ve:"+passwd.trim());
            if (accounts.containsKey(targetId.trim()) && accounts.get(targetId.trim()).equals(passwd.trim())){
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<valid>true</valid>");
                trobat = true;
            }
            
        } 
        if(!trobat){
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


