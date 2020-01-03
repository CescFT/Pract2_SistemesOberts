package ConnectionToJSPAuthentication;

import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.InterficieComuna;
import ModelEntities.Llogater;

import ServicesSingleton.AutenticacioServiceSingleton;
import ServicesSingleton.TenantServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
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

        clientWeb.setUsername(String.valueOf(sesion.getAttribute("nomUsuari")));
        clientWeb.setPassword(String.valueOf(sesion.getAttribute("contrassenyaUsuari")));
        System.out.println(clientWeb);

        Response resposta = autenticacio.getServeiAutenticacio().logoutUser(clientWeb);

        if (resposta.getStatus() == Response.Status.OK.getStatusCode()) {

            String paginaAnterior = request.getHeader("referer");
            String[] elemsPathAnterior = paginaAnterior.split("/"); // http://localhost:8080/Pract2_SistemesOberts/*.do
            String doAnterior = elemsPathAnterior[elemsPathAnterior.length - 1];
            sesion.setAttribute("nomUsuari", null);
            sesion.setAttribute("contrassenyaUsuari", null);
            sesion.setAttribute("token", null);

            TenantServiceSingleton tService = TenantServiceSingleton.getInstance();

            Response respostaTe = tService.getTenantService().removeToken();

            if (respostaTe.getStatus() == Response.Status.OK.getStatusCode()) {
                request.setAttribute("tenants", respostaTe.readEntity(String.class));
            } else if (respostaTe.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
                request.setAttribute("tenants", respostaTe.readEntity(String.class));
            } else if (respostaTe.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
                request.setAttribute("tenants", respostaTe.readEntity(String.class));
            }

            // 2. produce the view with the web result
            response.sendRedirect("/Pract2_SistemesOberts/" + doAnterior);
        } else if (resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
            request.setAttribute("logout", resposta.readEntity(String.class));

        } else if (resposta.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
            request.setAttribute("logout", resposta.readEntity(String.class));
        } else if (resposta.getStatus() == Response.Status.FORBIDDEN.getStatusCode()) {
            request.setAttribute("logout", resposta.readEntity(String.class));
        }

    }
}
