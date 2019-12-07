package ConnectionToJSPAuthentication;



import AuthenticationModule.credentialsClient;
import ModelEntities.InterficieComuna;
import ServicesSingleton.AutenticacioServiceSingleton;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class GetAllClientWebAuthorized implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
       AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();

        Response resposta = autenticacio.getServeiAutenticacio().getAllClientsAutoritzats_JSON();
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            request.setAttribute("clientsWeb", resposta.readEntity(new GenericType<List<credentialsClient>>(){}));
        }else if(resposta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
            request.setAttribute("clientsWeb", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/allClientWebAuthorized.jsp").forward(request, response);
    }
}
