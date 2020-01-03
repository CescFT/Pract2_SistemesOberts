package ConnectionToJSPTenants;

import AuthenticationModule.credentialsClient;
import AuthenticationModule.token;
import ModelEntities.Habitacio;
import ModelEntities.InterficieComuna;
import ModelEntities.Llogater;
import ModelEntities.Requeriment;
import ModelEntities.SexeLlogater;
import ModelEntities.TipusHabitacio;

import ServicesSingleton.TenantServiceSingleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

public class RentingRoom implements InterficieComuna {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        TenantServiceSingleton tService = TenantServiceSingleton.getInstance();

        Habitacio habToRent = new Habitacio();
        habToRent.setAdresa(request.getParameter("adre"));
        habToRent.setCiutat(request.getParameter("ciutat"));
        habToRent.setDescripcio(request.getParameter("des"));
        habToRent.setIdHabitacio(Long.valueOf(request.getParameter("id")));
        habToRent.setPreuMes(Float.valueOf(request.getParameter("preu")));
        Requeriment reqHabToRent = new Requeriment();
        reqHabToRent.setFumador(Boolean.valueOf(request.getParameter("fuma")));
        reqHabToRent.setMascotes(Boolean.valueOf(request.getParameter("masco")));
        reqHabToRent.setRangEdatMax(Integer.valueOf(request.getParameter("max")));
        reqHabToRent.setRangEdatMin(Integer.valueOf(request.getParameter("min")));
        reqHabToRent.setSexe(SexeLlogater.valueOf(request.getParameter("sexe")));
        habToRent.setRequeriment(reqHabToRent);
        habToRent.setTipusHabitacio(TipusHabitacio.valueOf(request.getParameter("tipu")));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String diaActual = dtf.format(localDate); //2016/11/16

        HttpSession sessio = request.getSession();
        String diaSessio = String.valueOf(sessio.getAttribute("dia"));

        Response res = tService.getTenantService().find_JSON(request.getParameter("idTenant"));
        boolean potLlogar = true;
        if (res.getStatus() == Response.Status.OK.getStatusCode()) {
            Llogater llogater = res.readEntity(Llogater.class);
            if (!diaSessio.equals(diaActual)) {
                    tService.getTenantService().nouDia(llogater);
                    sessio.setAttribute("dia", diaActual);
            }
            potLlogar = llogater.getNumLlogades() < 3 ? true : false;
            request.setAttribute("foundTenant", llogater);
        } else if (res.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
            request.setAttribute("foundTenant", res.readEntity(String.class));
        } else if (res.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
            request.setAttribute("foundTenant", res.readEntity(String.class));
        }

        if (potLlogar) {
            Response resposta = tService.getTenantService().rentingRoom_JSON(habToRent, request.getParameter("tenant"));
            if (resposta.getStatus() == Response.Status.CREATED.getStatusCode()) {
                request.setAttribute("roomRented", resposta.readEntity(Habitacio.class));
            } else if (resposta.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
                request.setAttribute("roomRented", resposta.readEntity(String.class));
            } else if (resposta.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
                request.setAttribute("roomRented", resposta.readEntity(String.class));
            }
        }

        // 2. produce the view with the web result
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/tenantRentedRoom.jsp").forward(request, response);
    }
}
