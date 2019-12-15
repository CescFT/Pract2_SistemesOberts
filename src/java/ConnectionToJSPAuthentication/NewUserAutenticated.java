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

public class NewUserAutenticated implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        credentialsClient clientWeb = new credentialsClient();
        
        clientWeb.setEmail("example@example.com");
        clientWeb.setPassword("12345"); 
        clientWeb.setUsername("CescFT");
        
        
        Response resposta = autenticacio.getServeiAutenticacio().createNewClientAutenticated(clientWeb);
        
        if(resposta.getStatus() == Response.Status.CREATED.getStatusCode()){
            request.setAttribute("newUser", resposta.readEntity(credentialsClient.class));
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("newUser", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/newUserWeb.jsp").forward(request, response);
    }
}
