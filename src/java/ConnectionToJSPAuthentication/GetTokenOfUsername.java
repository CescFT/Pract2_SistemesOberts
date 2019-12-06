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

public class GetTokenOfUsername implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        
        
        
        Response resposta = autenticacio.getServeiAutenticacio().getTokenOfUsername_JSON("cesc");
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            request.setAttribute("authorizedClient", resposta.readEntity(credentialsClient.class));
        }else if(resposta.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()){
            request.setAttribute("authorizedClient", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/tokenClientWeb.jsp").forward(request, response);
    }
}
