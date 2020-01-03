package ConnectionToJSPRooms;


import AuthenticationModule.credentialsClient;
import ModelEntities.InterficieComuna;
import ModelEntities.Habitacio;
import ModelEntities.TipusHabitacio;
import ServicesSingleton.AutenticacioServiceSingleton;
import ServicesSingleton.RoomServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class SearchRooms implements InterficieComuna {

    private String majusPrimeraLletra(String a){
        char[] aArray = a.toCharArray();
        String primeraLletra = String.valueOf(aArray[0]).toUpperCase();
        String resultat = a.replace(a.substring(0), primeraLletra);
        resultat = resultat + a.substring(1, a.length());
        return resultat;
    }
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        //RoomServiceSingleton r = RoomServiceSingleton.getInstance();
        // 1. process the request
        /*Response res;
        if(request.getParameter("location").equals("") || request.getParameter("location") == null){
            res=r.getService().findAllHabtacions(request.getParameter("sort"));
        }else{
            res = r.getService().find_JSON(request.getParameter("location"), request.getParameter("sort")); //Response res = r.getService().find_JSON(request.getParameter("location"), request.getParameter("sort"));
        }*/
        
        RoomServiceSingleton r = RoomServiceSingleton.getInstance();
        // 1. process the request
        String location="";
        if(request.getParameterMap().containsKey("location")){
            location = request.getParameter("location").toLowerCase() == null ? "" : request.getParameter("location").toLowerCase();
        }
        
        System.out.println(location);
        boolean noLocation=false;
        if(location.equals("")) noLocation=true;
        
        //String sort = request.getParameter("sort").toLowerCase();
        String sort = "desc";
        //if(sort.equals("")) sort ="desc";
        if(!location.equals("") && !sort.equals("")){
            Response res = r.getService().find_JSON(location, sort); 
            if(res.getStatus() == 200){
                List<Habitacio> llHabitacions = res.readEntity(new GenericType<List<Habitacio>>(){});
                List<Habitacio> llRes = new ArrayList<Habitacio>();
                for(Habitacio hab : llHabitacions){
                    String ciutatOk = this.majusPrimeraLletra(hab.getCiutat());
                    hab.setCiutat(ciutatOk);
                    llRes.add(hab);
                }
                request.setAttribute("rooms",  llRes);
            }else if (res.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()){
                request.setAttribute("rooms", null);
            } else if (res.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
                request.setAttribute("rooms", null);
            }
        }else if(noLocation){
            Response res = r.getService().findAllHabtacions(sort); 
               
            if(res.getStatus() == Response.Status.OK.getStatusCode()){
                List<Habitacio> llHabitacions = res.readEntity(new GenericType<List<Habitacio>>(){});
                List<Habitacio> llRes = new ArrayList<Habitacio>();
                for(Habitacio hab : llHabitacions){
                    String ciutatOk = this.majusPrimeraLletra(hab.getCiutat());
                    hab.setCiutat(ciutatOk);
                    llRes.add(hab);
                }
                request.setAttribute("rooms",  llRes);
            }else{
                if(res.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()){
                    request.setAttribute("rooms", null);
                }else{
                    request.setAttribute("rooms", null);
                }
            
            }
        }
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        Response resposta = autenticacio.getServeiAutenticacio().getAllClientsAutoritzats_JSON();
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            List<credentialsClient> llistaResultat = resposta.readEntity(new GenericType<List<credentialsClient>>(){});
            System.out.println(llistaResultat);
            request.setAttribute("clientsWeb", llistaResultat);
        }else if(resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
            request.setAttribute("clientsWeb", null);
        }
        
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/rooms.jsp").forward(request, response);
    }
}
