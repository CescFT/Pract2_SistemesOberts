package ModelEntities;

import AuthenticationModule.credentialsClient;
import ServicesSingleton.AutenticacioServiceSingleton;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Servlet que serveix per a generar un nou usuari, comprova que les dades estiguin bé
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public class ValidationServletUsernameNewUser extends HttpServlet {
    
    private ServletContext context;
    private HashMap accounts = new HashMap();
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    /**
     * Mètode que permet la connexió amb la base de dades i updatejar la informació.
     */
    private void update(){
        AutenticacioServiceSingleton login = AutenticacioServiceSingleton.getInstance();
        Response res = login.getServeiAutenticacio().getAllClientsAutoritzats_JSON();
        List<credentialsClient> llistatClientsAutenticats = res.readEntity(new GenericType<List<credentialsClient>>(){});
        for(credentialsClient c : llistatClientsAutenticats)
        {
            accounts.put(c.getUsername(),c.getEmail());
            
        }
    }
    
    /**
     * Mètode privat per a validar que el mail té format de mail
     * @param email mail
     * @return cert si esta be o fals si no
     */
    private boolean validateMail(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.update();
        
    }
    
    @Override
    public  void doGet(HttpServletRequest request, HttpServletResponse  response)
    throws IOException, ServletException {
        this.update();
        // Extract the data of the input form field whose name is "id"
        String targetId = request.getParameter("id");
        String email = request.getParameter("email");
        
        //  Send back either "<valid>true</valid>" or "<valid>false</valid>"
        //  XML message depending on the validity of the data that was entered.
        //  Note that the content type is "text/xml".
        //
        if(targetId != null && email != null){
            if(!accounts.containsKey(targetId.trim()) && targetId.trim()!="" && !accounts.values().contains(email.trim()) && email.trim()!=""){
                if(validateMail(email.trim())){
                    response.setContentType("text/xml");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getWriter().write("<valid>true</valid>");
                }else{
                    response.setContentType("text/xml");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getWriter().write("<valid>false</valid>");
                }
            }else{
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<valid>false</valid>");
            }
        }else{
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("<valid>false</valid>");
        }
    }
    
}


