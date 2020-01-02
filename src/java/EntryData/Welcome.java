package EntryData;



import ConnectionToJSPAuthentication.*;
import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.InterficieComuna;

import ServicesSingleton.AutenticacioServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class Welcome implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();

        Response resposta = autenticacio.getServeiAutenticacio().getAllClientsAutoritzats_JSON();
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            List<credentialsClient> llistaResultat = resposta.readEntity(new GenericType<List<credentialsClient>>(){});
            System.out.println(llistaResultat);
            request.setAttribute("clientsWeb", llistaResultat);
            request.setAttribute("numElems", llistaResultat.size());
        }else if(resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
            request.setAttribute("clientsWeb", resposta.readEntity(String.class));
        }
        
        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/index.jsp").forward(request, response);
        //context.getRequestDispatcher(request.getHeader("referer")).forward(request, response);
    }
}
