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

public class SearchAllRooms implements InterficieComuna {
    //PETA FORTAMENT I NO ENTENC PERQUE XDDDD
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        RoomServiceSingleton r = RoomServiceSingleton.getInstance();
        // 1. process the request
        Response res = r.getService().findAllHabtacions("ASC"); //nse perque peta.
               
        //System.out.println(res.readEntity(new GenericType<List<Habitacio>>(){}));
        if(res.getStatus() == Response.Status.OK.getStatusCode())
            request.setAttribute("rooms",  res.readEntity(new GenericType<List<Habitacio>>(){}));
        else{
            if(res.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()){
                request.setAttribute("rooms", res.readEntity(String.class));
            }else{
                request.setAttribute("rooms", "there was an error"+res.getStatusInfo());
            }
            
        }
            

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/rooms.jsp").forward(request, response);
    }
}
