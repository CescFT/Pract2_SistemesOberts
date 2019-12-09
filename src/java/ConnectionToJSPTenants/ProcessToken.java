package ConnectionToJSPTenants;


import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.InterficieComuna;

import ServicesSingleton.TenantServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import javax.ws.rs.core.Response;

public class ProcessToken implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        TenantServiceSingleton tService = TenantServiceSingleton.getInstance();
           
        token token = new token();
        token.setTokenAutoritzacio("cesc-FRERR2SNDIj9PNwW1HmbKH04paIsyzTv");
        
        Response resposta = tService.getTenantService().processamentProva_JSON(token);
        
        if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
            request.setAttribute("authorizedTenant", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
            request.setAttribute("authorizedTenant", resposta.readEntity(String.class));
        }else if(resposta.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()){
            request.setAttribute("authorizedTenant", resposta.readEntity(String.class));
        }
        

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/tenantAutenticated.jsp").forward(request, response);
    }
}
