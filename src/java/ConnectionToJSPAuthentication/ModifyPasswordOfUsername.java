package ConnectionToJSPAuthentication;



import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.InterficieComuna;

import ServicesSingleton.AutenticacioServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import javax.ws.rs.core.Response;

public class ModifyPasswordOfUsername implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        credentialsClient clientWeb = new credentialsClient();
        
        
        String password = request.getParameter("passwd");
        boolean havePassword= password.equals("") ? false : true;
        String username = request.getParameter("username");
        boolean haveUsername = username.equals("") ? false : true;
        
        if(!havePassword)
            request.setAttribute("modifiedPasswdUser", "Falta contrassenya.");
        if(!haveUsername)
            request.setAttribute("modifiedPasswdUser", "Falta nom usuari.");
        
        if(havePassword && haveUsername){
            clientWeb.setPassword(password); 
            clientWeb.setUsername(username);

            Response resposta = autenticacio.getServeiAutenticacio().modifyPasswordOfClient(clientWeb);
            System.out.println(resposta.getStatus());
            if(resposta.getStatus() == Response.Status.OK.getStatusCode()){
                request.setAttribute("modifiedPasswdUser", resposta.readEntity(credentialsClient.class));
            }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
                request.setAttribute("modifiedPasswdUser", resposta.readEntity(String.class));
            }else if(resposta.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()){
                request.setAttribute("modifiedPasswdUser", resposta.readEntity(String.class));
            }else if(resposta.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()){
                request.setAttribute("modifiedPasswdUser", resposta.readEntity(String.class));
            }
            
        }

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/modifiedUserWeb.jsp").forward(request, response);
    }
}
