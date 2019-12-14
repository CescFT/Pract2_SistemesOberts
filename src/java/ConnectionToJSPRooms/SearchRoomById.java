package ConnectionToJSPRooms;


import ModelEntities.InterficieComuna;
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

public class SearchRoomById implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        RoomServiceSingleton r = RoomServiceSingleton.getInstance();
        // 1. process the request
        Response res = r.getService().findHabitacio(Integer.valueOf(request.getParameter("idRoom")));
        
        if(res.getStatus() == 200){
            request.setAttribute("roomById", res.readEntity(new GenericType<List<Habitacio>>(){}));
        }else if (res.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()){
            request.setAttribute("roomById", res.readEntity(String.class));
        }
            

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/roomById.jsp").forward(request, response);
    }
}
