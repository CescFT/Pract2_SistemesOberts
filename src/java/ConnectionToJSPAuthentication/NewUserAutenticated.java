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

public class NewUserAutenticated implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        AutenticacioServiceSingleton autenticacio = AutenticacioServiceSingleton.getInstance();
        credentialsClient clientWeb = new credentialsClient();
        
        String mail = request.getParameter("email");
        boolean haveMail = mail.equals("") ? false : true;
        String password = request.getParameter("passwd");
        boolean havePassword= password.equals("") ? false : true;
        String username = request.getParameter("username");
        boolean haveUsername = username.equals("") ? false : true;
        
        if(!haveMail)
            request.setAttribute("newUser", "Falta correu electronic.");
        if(!havePassword)
            request.setAttribute("newUser", "Falta contrassenya.");
        if(!haveUsername)
            request.setAttribute("newUser", "Falta nom usuari.");
        
        if(haveMail && havePassword && haveUsername){
            clientWeb.setEmail(mail);
            clientWeb.setPassword(password); 
            clientWeb.setUsername(username);

            Response resposta = autenticacio.getServeiAutenticacio().createNewClientAutenticated(clientWeb);
        
            if(resposta.getStatus() == Response.Status.CREATED.getStatusCode()){
                request.setAttribute("newUser", resposta.readEntity(credentialsClient.class));
            }else if(resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()){
                request.setAttribute("newUser", resposta.readEntity(String.class));
            }
        }

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/newUserWeb.jsp").forward(request, response);
    }
}