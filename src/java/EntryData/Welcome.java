package EntryData;


import AuthenticationModule.credentialsClient;
import ModelEntities.InterficieComuna;
import ServicesSingleton.AutenticacioServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Classe Java que permet que la classe principal també sigui un .do. 
 * Carrega elements que es necessiten per a la sessió establerta.
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public class Welcome implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesio = request.getSession();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        
        
        sesio.setAttribute("dia", dtf.format(localDate));
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();

        Response resposta = autenticacio.getServeiAutenticacio().getAllClientsAutoritzats_JSON();
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            List<credentialsClient> llistaResultat = resposta.readEntity(new GenericType<List<credentialsClient>>(){});
            System.out.println(llistaResultat);
            request.setAttribute("clientsWeb", llistaResultat);
        }else if(resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
            request.setAttribute("clientsWeb", resposta.readEntity(String.class));
        }
        
        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/index.jsp").forward(request, response);
        //context.getRequestDispatcher(request.getHeader("referer")).forward(request, response);
    }
}
