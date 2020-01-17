/*
 * CLIENT REST PER A L'AUTENTICACIÓ
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
 * @authors Aleix Sancho i Francesc Ferré
 */
public class AutenticacioClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RESTServiceForPract2SistemesOberts/webresources/";

    /**
     * Constructor
     */
    public AutenticacioClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("autenticacio");
    }

    /**
     * Mètode per a cridar al logout de la API REST
     * @param requestEntity client
     * @return logout client
     * @throws ClientErrorException error al connectar-se
     */
    public Response logoutUser(Object requestEntity) throws ClientErrorException{
        WebTarget resource = webTarget;
        resource = resource.path("logoutUser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }
    
    /**
     * Mètode per a registrar un nou client web de la API REST
     * @param requestEntity client
     * @return nou usuari registrat
     * @throws ClientErrorException error al connectar-se
     */
    public Response createNewClientAutenticated(Object requestEntity) throws ClientErrorException{
        WebTarget resource =webTarget;
        resource=resource.path("newClient");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);  
    }
    
    /**
     * Mètode per a retornar tots els clients autoritzats en XML de la API REST
     * @return llistat dels clients autoritzats.
     * @throws ClientErrorException error al connectar-se
     */
    public Response getAllClientsAutoritzats_XML() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("all");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    /**
     * Mètode per a retornar tots els clients autoritzats en JSON de la API REST
     * @return llistat dels clients autoritzats.
     * @throws ClientErrorException error al connectar-se
     */
    public Response getAllClientsAutoritzats_JSON() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("all");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }

    /**
     * Mètode per a retornar el client autoritzat en format XML de la API REST
     * @param username nom usuari
     * @return client web
     * @throws ClientErrorException error al connectar-se
     */
    public Response getClientAutenticate_XML(String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (username != null) {
            resource = resource.queryParam("username", username);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    /**
     * Mètode per a retornar el client autoritzat en format JSON de la API REST
     * @param username nom usuari
     * @return client web
     * @throws ClientErrorException error al connectar-se
     */
    public Response getClientAutenticate_JSON(String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (username != null) {
            resource = resource.queryParam("username", username);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }

    /**
     * Mètode per a fer login
     * @param requestEntity usuari
     * @return usuari loggejat
     * @throws ClientErrorException error al connectar-se
     */
    public Response authenticationClient(Object requestEntity) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    /**
     * Getter del token en format XML de la API REST
     * @param username nom usuari
     * @return token de l'usuari
     * @throws ClientErrorException error al connectar-se
     */
    public Response getTokenOfUsername_XML(String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    /**
     * Mètode per a retornar el token en format JSON de la API REST
     * @param username nom usuari
     * @return token
     * @throws ClientErrorException error al connectar-se
     */
    public Response getTokenOfUsername_JSON(String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }
    
    /**
     * Mètode per a tancar la comunicació
     */
    public void close() {
        client.close();
    }
    
}
