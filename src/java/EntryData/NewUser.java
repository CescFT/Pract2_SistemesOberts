package EntryData;


import ModelEntities.InterficieComuna;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Classe Java que permet obrir el JSP per a registrar-se
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
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
