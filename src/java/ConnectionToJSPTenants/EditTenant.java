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

public class EditTenant implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        TenantServiceSingleton tService = TenantServiceSingleton.getInstance();
           
        Llogater editarLlogater = new Llogater();
        
        editarLlogater.setId(Long.valueOf(50));
        informacioLlogater infoLlogaterToEdit = new informacioLlogater();
        infoLlogaterToEdit.setCognom("Sanchez");
        infoLlogaterToEdit.setDni("25789635-K");
        infoLlogaterToEdit.setEdat(19);
        infoLlogaterToEdit.setFumador(true);
        infoLlogaterToEdit.setNom("Marc");
        infoLlogaterToEdit.setSexe(SexeLlogater.HOME);
        infoLlogaterToEdit.setTeMascotes(false);
        editarLlogater.setInfo(infoLlogaterToEdit);
        
        
        Response resposta = tService.getTenantService().editLlogater_JSON(editarLlogater, String.valueOf(50));
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            request.setAttribute("editedTenant", resposta.readEntity(Llogater.class));
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("editedTenant", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()){
            request.setAttribute("editedTenant", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/editedTenant.jsp").forward(request, response);
    }
}
