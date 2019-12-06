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

public class WebClientAuthentication implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        credentialsClient clientWeb = new credentialsClient();
        
        clientWeb.setEmail("77792731-S@estudiants.urv.cat");
        clientWeb.setPassword("EN0YcrWsjDJprO5tc0TgyIviTq2W5kIf"); //la password cada cop
        clientWeb.setUsername("cesc");
        
        
        Response resposta = autenticacio.getServeiAutenticacio().authenticationClient(clientWeb);
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            request.setAttribute("authorized", resposta.readEntity(token.class));
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("authorized", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
            request.setAttribute("authorized", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/clientWebAuthentication.jsp").forward(request, response);
    }
}
