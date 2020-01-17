package ConnectionToJSPAuthentication;

import AuthenticationModule.credentialsClient;
import ModelEntities.InterficieComuna;
import ServicesSingleton.AutenticacioServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import javax.ws.rs.core.Response;

/**
 * Classe Java que permet generar un nou usuari autenticat (registrar-se)
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public class NewUserAutenticated implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        credentialsClient clientWeb = new credentialsClient();
        
        String mail = request.getParameter("mail");
        boolean haveMail = mail.equals("") ? false : true;
        String password = request.getParameter("password");
        boolean havePassword= password.equals("") ? false : true;
        String username = request.getParameter("username");
        boolean haveUsername = username.equals("") ? false : true;
        
        if(!haveMail)
            request.setAttribute("newUser", "Falta correu electronic.");
        if(!havePassword)
            request.setAttribute("newUser", "Falta contrassenya.");
        if(!haveUsername)
            request.setAttribute("newUser", "Falta nom usuari.");
        
        if(haveMail && havePassword && haveUsername){
            clientWeb.setEmail(mail);
            clientWeb.setPassword(password); 
            clientWeb.setUsername(username);

            Response resposta = autenticacio.getServeiAutenticacio().createNewClientAutenticated(clientWeb);
      
            if(resposta.getStatus() == Response.Status.CREATED.getStatusCode()){
                request.setAttribute("newUser", resposta.readEntity(credentialsClient.class));
            }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
                request.setAttribute("newUser", resposta.readEntity(String.class));
            }else if(resposta.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()){
                request.setAttribute("newUser", resposta.readEntity(String.class));
            }
            
        }

        String paginaAnterior = request.getHeader("referer");
        String[] elemsPathAnterior= paginaAnterior.split("/"); // http://localhost:8080/Pract2_SistemesOberts/*.do
        String doAnterior = elemsPathAnterior[elemsPathAnterior.length-1];
        System.out.println(doAnterior);
        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/"+doAnterior).forward(request, response);
    }
}
