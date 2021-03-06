package ConnectionToJSPRooms;

import AuthenticationModule.credentialsClient;
import ModelEntities.InterficieComuna;
import ModelEntities.Habitacio;
import ModelEntities.Llogater;
import ServicesSingleton.AutenticacioServiceSingleton;
import ServicesSingleton.RoomServiceSingleton;
import ServicesSingleton.TenantServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Classe que permet recuperar la informació d'una habitació en específic
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public class SearchRoomById implements InterficieComuna {

    /**
     * Mètode privat que permet formatejar el nom de la ciutat
     * @param a ciutat
     * @return string de la ciutat formatejada
     */
    private String majusPrimeraLletra(String a){
        char[] aArray = a.toCharArray();
        String primeraLletra = String.valueOf(aArray[0]).toUpperCase();
        String resultat = a.replace(a.substring(0), primeraLletra);
        resultat = resultat + a.substring(1, a.length());
        return resultat;
    }
    
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Response res;
        RoomServiceSingleton r = RoomServiceSingleton.getInstance();
        // 1. process the request
        HttpSession session = request.getSession();
        String idHab = request.getParameter("idRoom");
        if (idHab != null){
            session.setAttribute("idHabitacio", request.getParameter("idRoom"));
            res = r.getService().findHabitacio(Integer.valueOf(idHab));
        }else{
            res = r.getService().findHabitacio(Integer.valueOf(String.valueOf(session.getAttribute("idHabitacio"))));
        }

        if (res.getStatus() == 200) {
           Habitacio habitacioEscollida = res.readEntity(Habitacio.class);
           String ciutatOk = this.majusPrimeraLletra(habitacioEscollida.getCiutat());
           habitacioEscollida.setCiutat(ciutatOk);
           
            request.setAttribute("roomById", habitacioEscollida);
        } else if (res.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
            request.setAttribute("roomById", res.readEntity(String.class));
        }

        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();

        Response resposta = autenticacio.getServeiAutenticacio().getAllClientsAutoritzats_JSON();
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            List<credentialsClient> llistaResultat = resposta.readEntity(new GenericType<List<credentialsClient>>(){});
            System.out.println(llistaResultat);
            request.setAttribute("clientsWeb", llistaResultat);
        }else if(resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
            request.setAttribute("clientsWeb", resposta.readEntity(String.class));
        }
        
        TenantServiceSingleton tService = TenantServiceSingleton.getInstance();

        Response resposta1 = tService.getTenantService().listOfTenants_JSON();
        
        if(resposta1.getStatus() == Response.Status.OK.getStatusCode()){
            request.setAttribute("tenants", resposta1.readEntity(new GenericType<List<Llogater>>(){}));
        }else if(resposta1.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("tenants", resposta1.readEntity(String.class));
        }else if(resposta1.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()){
            request.setAttribute("tenants", resposta1.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/roomById.jsp").forward(request, response);
    }
}
