package ConnectionToJSPTenants;


import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.Habitacio;
import ModelEntities.InterficieComuna;
import ModelEntities.Requeriment;
import ModelEntities.SexeLlogater;
import ModelEntities.TipusHabitacio;

import ServicesSingleton.TenantServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import javax.ws.rs.core.Response;

public class RentingRoom implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        TenantServiceSingleton tService = TenantServiceSingleton.getInstance();
           
        Habitacio habToRent = new Habitacio();
        habToRent.setAdresa("Avda. Catalunya 2");
        habToRent.setCiutat("Vallmoll");
        habToRent.setDescripcio("Es una mica cara.");
        habToRent.setIdHabitacio(Long.valueOf(300));
        habToRent.setPreuMes(Float.valueOf(120));
        Requeriment reqHabToRent = new Requeriment();
        reqHabToRent.setFumador(true);
        reqHabToRent.setMascotes(true);
        reqHabToRent.setRangEdatMax(99);
        reqHabToRent.setRangEdatMin(10);
        reqHabToRent.setSexe(SexeLlogater.UNISEX);
        habToRent.setRequeriment(reqHabToRent);
        habToRent.setTipusHabitacio(TipusHabitacio.INTERIOR);
        
        
        
        Response resposta = tService.getTenantService().rentingRoom_JSON(habToRent, String.valueOf(50));
        
        if(resposta.getStatus() == Response.Status.CREATED.getStatusCode()){
            request.setAttribute("roomRented", resposta.readEntity(Habitacio.class));
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("roomRented", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()){
            request.setAttribute("roomRented", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/tenantRentedRoom.jsp").forward(request, response);
    }
}
