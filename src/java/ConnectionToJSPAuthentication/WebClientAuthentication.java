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
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

/**
 * Classe Java que permet fer un login
 *
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public class WebClientAuthentication implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        credentialsClient clientWeb = new credentialsClient();
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("username"));
        clientWeb.setPassword(request.getParameter("password")); //aqui sa de posar el nom del parametre que sigui per a aquest .java
        clientWeb.setUsername(request.getParameter("username"));  //de la mateixa forma aqui

        Response resposta = autenticacio.getServeiAutenticacio().authenticationClient(clientWeb);
        token token = new token();
        if (resposta.getStatus() == Response.Status.OK.getStatusCode()) {
            token = resposta.readEntity(token.class);
            request.setAttribute("authorized", token);

            String paginaAnterior = request.getParameter("anterior");
            String[] elemsPathAnterior = paginaAnterior.split("/"); // http://localhost:8080/Pract2_SistemesOberts/*.do
            String doAnterior = elemsPathAnterior[elemsPathAnterior.length - 1];

            System.out.println(doAnterior);
            System.out.println(token.getTokenAutoritzacio());
            HttpSession sesion = request.getSession();
            sesion.setAttribute("token", token.getTokenAutoritzacio());
            sesion.setAttribute("nomUsuari", clientWeb.getUsername());
            sesion.setAttribute("contrassenyaUsuari", clientWeb.getPassword());
            // 2. produce the view with the web result

            TenantServiceSingleton tService = TenantServiceSingleton.getInstance();

            token tokenAu = new token();
            tokenAu.setTokenAutoritzacio(token.getTokenAutoritzacio());

            Response respostaAu = tService.getTenantService().processamentProva_JSON(tokenAu);

            if (respostaAu.getStatus() == Response.Status.OK.getStatusCode()) {
                request.setAttribute("authorizedTenant", respostaAu.readEntity(String.class));
            } else if (respostaAu.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
                request.setAttribute("authorizedTenant", respostaAu.readEntity(String.class));
            } else if (respostaAu.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
                request.setAttribute("authorizedTenant", respostaAu.readEntity(String.class));
            }

            response.sendRedirect("/Pract2_SistemesOberts/" + doAnterior);
        } else if (resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
            request.setAttribute("authorized", resposta.readEntity(String.class));

        } else if (resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
            request.setAttribute("authorized", resposta.readEntity(String.class));
        }

    }
}
