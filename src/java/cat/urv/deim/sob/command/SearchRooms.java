package cat.urv.deim.sob.command;

import cat.urv.deim.rest.RoomClient;
import cat.urv.deim.sob.Habitacio;
import cat.urv.deim.sob.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class SearchRooms implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        RoomClient r = new RoomClient();
        // 1. process the request
        Response res = r.find_XML("Valls", "asc");
        request.setAttribute("rooms",  res.readEntity(new GenericType<List<Habitacio>>(){}));

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/rooms.jsp").forward(request, response);
    }
}
