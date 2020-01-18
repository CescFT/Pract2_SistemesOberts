package ConnectionToJSPAuthentication;

import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.InterficieComuna;
import ServicesSingleton.AutenticacioServiceSingleton;
import ServicesSingleton.TenantServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

/**
 * Classe Java que permet trobar la informació d'un client web autenticat
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public class InfoClientWeb implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

       AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        

        HttpSession sesion = request.getSession();
        Response resposta = autenticacio.getServeiAutenticacio().getInfoClientWeb(String.valueOf(sesion.getAttribute("nomUsuari")));

        if (resposta.getStatus() == Response.Status.OK.getStatusCode()) {
            request.setAttribute("user", resposta.readEntity(credentialsClient.class));
        } else if (resposta.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
            request.setAttribute("user", resposta.readEntity(String.class));
        } else if (resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
            request.setAttribute("user", resposta.readEntity(String.class));
        }

        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/prova.jsp").forward(request, response);
    }
}
