/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restClients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:autenticacioClientWeb
 * [/autenticacio]<br>
 * USAGE:
 * <pre>
 *        AutenticacioClient client = new AutenticacioClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Sancho
 */
public class AutenticacioClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Pract1_SistemesOberts/webresources";

    public AutenticacioClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("autenticacio");
    }

    public Response getAllClientsAutoritzats_XML() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("all");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    public Response getAllClientsAutoritzats_JSON() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("all");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }

    public Response getClientAutenticate_XML(String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (username != null) {
            resource = resource.queryParam("username", username);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    public Response getClientAutenticate_JSON(String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (username != null) {
            resource = resource.queryParam("username", username);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }

    public Response authenticationClient() throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(null, Response.class);
    }

    public Response getTokenOfUsername_XML(String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    public Response getTokenOfUsername_JSON(String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }

    public Response getMevaContrassenya_XML(String username, String token) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{username, token}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    public Response getMevaContrassenya_JSON(String username, String token) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{username, token}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }

    public void close() {
        client.close();
    }
    
}
