package ConnectionToJSPRooms;


import ModelEntities.InterficieComuna;
import ModelEntities.Habitacio;
import ModelEntities.Requeriment;
import ModelEntities.SexeLlogater;
import ModelEntities.TipusHabitacio;
import ServicesSingleton.RoomServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class CreateRoom implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        RoomServiceSingleton r = RoomServiceSingleton.getInstance();
        Habitacio novaHabitacio = new Habitacio();
        
        novaHabitacio.setAdresa("C/ rambla vella 12");
        novaHabitacio.setCiutat("Tarragona");
        novaHabitacio.setDescripcio("Casa molt acollidora");
        novaHabitacio.setIdHabitacio(Long.valueOf(400));
        novaHabitacio.setLlogater(null);
        novaHabitacio.setPreuMes(478);
        Requeriment requerimentH = new Requeriment();
        requerimentH.setFumador(false);
        requerimentH.setMascotes(true);
        requerimentH.setRangEdatMax(46);
        requerimentH.setRangEdatMin(21);
        requerimentH.setSexe(SexeLlogater.UNISEX);
        novaHabitacio.setRequeriment(requerimentH);
        novaHabitacio.setTipusHabitacio(TipusHabitacio.INTERIOR);
        
        Response resposta = r.getService().createHabitacio_JSON(novaHabitacio);
        
        if(resposta.getStatus() == Response.Status.CREATED.getStatusCode()){
            request.setAttribute("created", resposta.readEntity(Habitacio.class));
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("created", resposta.readEntity(Habitacio.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/createRoom.jsp").forward(request, response);
    }
}
