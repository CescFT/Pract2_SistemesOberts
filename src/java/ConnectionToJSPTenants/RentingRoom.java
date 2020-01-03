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
        habToRent.setAdresa(request.getParameter("adre"));
        habToRent.setCiutat(request.getParameter("ciutat"));
        habToRent.setDescripcio(request.getParameter("des"));
        habToRent.setIdHabitacio(Long.valueOf(request.getParameter("id")));
        habToRent.setPreuMes(Float.valueOf(request.getParameter("preu")));
        Requeriment reqHabToRent = new Requeriment();
        reqHabToRent.setFumador(Boolean.valueOf(request.getParameter("fuma")));
        reqHabToRent.setMascotes(Boolean.valueOf(request.getParameter("masco")));
        reqHabToRent.setRangEdatMax(Integer.valueOf(request.getParameter("max")));
        reqHabToRent.setRangEdatMin(Integer.valueOf(request.getParameter("min")));
        reqHabToRent.setSexe(SexeLlogater.valueOf(request.getParameter("sexe")));
        habToRent.setRequeriment(reqHabToRent);
        habToRent.setTipusHabitacio(TipusHabitacio.valueOf(request.getParameter("tipu")));
        
        
        
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
