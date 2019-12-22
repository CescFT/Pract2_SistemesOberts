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

public class WebClientAuthentication implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        credentialsClient clientWeb = new credentialsClient();
        
        clientWeb.setPassword(request.getParameter("passwd")); //aqui sa de posar el nom del parametre que sigui per a aquest .java
        clientWeb.setUsername(request.getParameter("id"));  //de la mateixa forma aqui
        
        
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
        String paginaAnterior = request.getHeader("referer");
        String[] elemsPathAnterior= paginaAnterior.split("/"); // http://localhost:8080/Pract2_SistemesOberts/*.do
        String doAnterior = elemsPathAnterior[elemsPathAnterior.length-1];
        System.out.println(doAnterior);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("token", token.getTokenAutoritzacio());
        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/clientWebAuthentication.jsp").forward(request, response);
        //context.getRequestDispatcher(soAnterior).forward(request, response);
    }
}
