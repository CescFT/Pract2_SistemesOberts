package ModelEntities;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 * Servlet principal que rep totes les peticions que tenen per extensió el .do
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public class ControllerServlet extends HttpServlet {

     private final Map<String, InterficieComuna> commands = new HashMap<>();

    @Override
    public void init() throws ServletException{
        ServletContext ctx = getServletContext();
        InputStream input = ctx.getResourceAsStream("/WEB-INF/" + getServletConfig().getInitParameter("setup"));
        try {
            JsonReader reader = Json.createReader(input);
            JsonObject setup = reader.readObject();
        
            for(JsonValue value: setup.getJsonArray("commands")){
                JsonObject command = (JsonObject) value;
                Class<?> clazz = Class.forName(command.getString("class"));
                commands.put(ctx.getContextPath() + command.getString("URI") + ".do", (InterficieComuna) clazz.newInstance());
            }
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }
    }

    /**
     * Mètode que permet processar un command
     * @param request peticio HTTP
     * @param response resposta HTTP
     * @throws ServletException error en el servlet
     * @throws IOException error d'entrada o sortida
     */
    protected void processCommand(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // 1. choose action
        String URI = request.getRequestURI();
        System.out.println(URI);
        // 2. choose related command
        InterficieComuna command = (InterficieComuna) commands.get(URI);

        if (null == command) {
            throw new IllegalArgumentException(
                    "No command for form action: " + URI);
        }

        // 3. run the command
        command.execute(request, response);
    }

    @Override
    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processCommand(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processCommand(request, response);
    }
}
