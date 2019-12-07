package ConnectionToJSPAuthentication;



import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.InterficieComuna;

import ServicesSingleton.AutenticacioServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import javax.ws.rs.core.Response;

public class GetMyPassword implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        
        
        
        Response resposta = autenticacio.getServeiAutenticacio().getMevaContrassenya_JSON("cesc", "cesc-xCzo9VuYixz4sJGNZ3KnFvl7sZWlCUkl");
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            request.setAttribute("clientPassword", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()){
            request.setAttribute("clientPassword", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
            request.setAttribute("clientPassword", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("clientPassword", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/passwordClientWeb.jsp").forward(request, response);
    }
}