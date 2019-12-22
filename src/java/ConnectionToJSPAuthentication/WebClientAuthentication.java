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
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

public class WebClientAuthentication implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        credentialsClient clientWeb = new credentialsClient();
        
        clientWeb.setPassword(request.getParameter("passwd")); //la password cada cop
        clientWeb.setUsername(request.getParameter("id"));
        
        
        Response resposta = autenticacio.getServeiAutenticacio().authenticationClient(clientWeb);
        token token = new token();
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            token = resposta.readEntity(token.class);
            request.setAttribute("authorized", token);
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("authorized", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
            request.setAttribute("authorized", resposta.readEntity(String.class));
        }
        
        /*AIXO FUNCIONA! LA IDEA ÉS:
            GUARDAR EN L'AMBIT SESSIO EL TOKEN, PILLARLO ALS LLOCS ON SIGUI I JA ESTA
            AMB LA CAPÇALERA REFERER TENIM LA URL DE ON VENIM, LLAVORS ANEM A LANTERIOR I TENOM LA INFORMACIO DE LUSUARI
            JA GUARDADA I ESTA AUTENTICAT
        https://es.stackoverflow.com/questions/33250/c%C3%B3mo-puedo-guardar-un-objeto-en-la-sesi%C3%B3n-y-c%C3%B3mo-utilizarlo-en-un-jsp-servle
        De la referer mhaig de quedar amb l'ultima /i amb el loquesigui.do
            */
        
        
        request.setAttribute("authorized",request.getHeader("referer")); //http://localhost:8080/PRac.../.do
        HttpSession sesion = request.getSession();
        sesion.setAttribute("token", token.getTokenAutoritzacio());
        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/clientWebAuthentication.jsp").forward(request, response);
        //context.getRequestDispatcher(request.getHeader("referer")).forward(request, response);
    }
}
