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
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

public class LogoutUser implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        credentialsClient clientWeb = new credentialsClient();
        
        HttpSession sesion = request.getSession();
        clientWeb.setUsername(sesion.getAttribute("nomUsuari").toString());  //de la mateixa forma aqui

        Response resposta = autenticacio.getServeiAutenticacio().logoutUser(clientWeb);
        
        if (resposta.getStatus() == Response.Status.OK.getStatusCode()) {
            
            
            String paginaAnterior = request.getParameter("anterior");
            String[] elemsPathAnterior = paginaAnterior.split("/"); // http://localhost:8080/Pract2_SistemesOberts/*.do
            String doAnterior = elemsPathAnterior[elemsPathAnterior.length - 1];
            
            System.out.println(doAnterior);
            
            // 2. produce the view with the web result
            
            response.sendRedirect("/Pract2_SistemesOberts/" + doAnterior);
        } else if (resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
            request.setAttribute("logout", resposta.readEntity(String.class));
            
        } else if (resposta.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
            request.setAttribute("logout", resposta.readEntity(String.class));
        }else if (resposta.getStatus() == Response.Status.FORBIDDEN.getStatusCode()) {
            request.setAttribute("logout", resposta.readEntity(String.class));
        }

       
         
        
    }
}
