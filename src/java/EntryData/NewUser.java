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
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

public class NewUser implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        
        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/EntryDataForNewUser.jsp").forward(request, response);
        //context.getRequestDispatcher(request.getHeader("referer")).forward(request, response);
    }
}
