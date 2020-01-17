package ModelEntities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Interfíce per a poder fer que els java implementin i puguin respondre a la peticio HTTP entrant
 * @author Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public interface InterficieComuna {

    public void execute(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException;
}
