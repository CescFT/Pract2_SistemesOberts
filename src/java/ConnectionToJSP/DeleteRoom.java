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

public class DeleteRoom implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        RoomServiceSingleton r = RoomServiceSingleton.getInstance();
        // 1. process the request
        Response res = r.getService().remove(String.valueOf(150));
        
        if(res.getStatus() == 200){
            request.setAttribute("eliminated", res.readEntity(String.class));
        }else if (res.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("eliminated", res.readEntity(String.class));
        }
        
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/eliminateRoom.jsp").forward(request, response);
    }
}
