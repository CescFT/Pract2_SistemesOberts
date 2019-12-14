package ConnectionToJSPTenants;


import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.Habitacio;
import ModelEntities.InterficieComuna;
import ModelEntities.Llogater;
import ModelEntities.Requeriment;
import ModelEntities.SexeLlogater;
import ModelEntities.TipusHabitacio;
import ModelEntities.informacioLlogater;

import ServicesSingleton.TenantServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import javax.ws.rs.core.Response;

public class FreeRoom implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        TenantServiceSingleton tService = TenantServiceSingleton.getInstance();

        Response resposta = tService.getTenantService().alliberarHabitacio(request.getParameter("idHab"));
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            request.setAttribute("roomFree", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("roomFree", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()){
            request.setAttribute("roomFree", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/freeRoom.jsp").forward(request, response);
    }
}
