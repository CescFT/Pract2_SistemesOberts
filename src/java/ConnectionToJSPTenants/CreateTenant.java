package ConnectionToJSPTenants;


import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.Habitacio;
import ModelEntities.InterficieComuna;
import ModelEntities.Llogater;
import ModelEntities.Requeriment;
import ModelEntities.SexeLlogater;
import ModelEntities.TipusHabitacio;
import ModelEntities.InformacioLlogater;

import ServicesSingleton.TenantServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import javax.ws.rs.core.Response;

public class CreateTenant implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        TenantServiceSingleton tService = TenantServiceSingleton.getInstance();
           
        Llogater nouLlogater = new Llogater();
        
        nouLlogater.setId(Long.valueOf(60));
        InformacioLlogater infoLlogaterNou = new InformacioLlogater();
        infoLlogaterNou.setCognom("Perez");
        infoLlogaterNou.setDni("44485962-V");
        infoLlogaterNou.setEdat(22);
        infoLlogaterNou.setFumador(false);
        infoLlogaterNou.setNom("Jordi");
        infoLlogaterNou.setSexe(SexeLlogater.HOME);
        infoLlogaterNou.setTeMascotes(false);
        nouLlogater.setInfo(infoLlogaterNou);
        
        
        Response resposta = tService.getTenantService().createLlogater_JSON(nouLlogater);
        
        if(resposta.getStatus() == Response.Status.CREATED.getStatusCode()){
            request.setAttribute("newTenant", resposta.readEntity(Llogater.class));
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("newTenant", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()){
            request.setAttribute("newTenant", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/createdNewTenant.jsp").forward(request, response);
    }
}
