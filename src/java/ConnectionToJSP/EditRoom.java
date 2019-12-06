package ConnectionToJSP;


import ModelEntities.Habitacio;
import ServicesSingleton.RoomServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class EditRoom implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        RoomServiceSingleton r = RoomServiceSingleton.getInstance();
        // 1. process the request
        Response res = r.getService().findHabitacio(100);
        
        Habitacio hab = res.readEntity(Habitacio.class);
        hab.setPreuMes(125);
        
        Response resPut = r.getService().editHabitacio_JSON(hab, String.valueOf(100));
        
        if(resPut.getStatus() == Response.Status.OK.getStatusCode()){
            request.setAttribute("modified", resPut.readEntity(Habitacio.class));
        }else if(resPut.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("modified", resPut.readEntity(String.class));
        }
        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/modifiedRoom.jsp").forward(request, response);
    }
}
