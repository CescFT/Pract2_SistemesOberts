/*
 * CLIENT REST PER ALS LLOGATERS
 */
package restClients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:LlogaterFacadeREST
 * [tenant]<br>
 * USAGE:
 * <pre>
 *        TenantClient client = new TenantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @authors Aleix Sancho i Francesc Ferré
 */
public class TenantClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RESTServiceForPract2SistemesOberts/webresources/";

    /**
     * Constructor
     */
    public TenantClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("tenant");
    }
    
    /**
     * Mètode que permet cridar la API REST i reiniciar el comptador de llogadews d'un llogater específic
     * @param requestEntity llogater
     * @return llogater amb zero llogades
     * @throws ClientErrorException error al connectar-se
     */
    public Response nouDia(Object requestEntity) throws ClientErrorException{
        WebTarget resource = webTarget;
        resource = resource.path("nouDia");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        
    }
    
    /**
     * Mètode que permet llogar l'habitacio connectant-se a la API REST, format XML
     * @param requestEntity habitacio
     * @param id llogater
     * @return habitacio llogada
     * @throws ClientErrorException error al connectar-se
     */
    public Response rentingRoom_XML(Object requestEntity, String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}/rent", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    /**
     * Mètode que permet llogar l'habitacio connectant-se a la API REST, format JSON
     * @param requestEntity habitacio
     * @param id llogater
     * @return habitacio llogada
     * @throws ClientErrorException error al connectar-se
     */
    public Response rentingRoom_JSON(Object requestEntity, String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}/rent", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    /**
     * Mètode que permet cercar el llogater donada la id connectant-se a la API REST, format XML
     * @param id llogater
     * @return llogater
     * @throws ClientErrorException error al connectar-se
     */
    public Response find_XML(String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    /**
     * Mètode que permet cercar el llogater donada la id connectant-se a la API REST, format JSON
     * @param id llogater
     * @return llogater
     * @throws ClientErrorException error al connectar-se
     */
    public Response find_JSON(String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }
    
    /**
     * Mètode que permet recuperar tots els llogaters en format XML connectant-se a la API REST
     * @return llistat de llogaters
     * @throws ClientErrorException error al connectar-se
     */
    public Response listOfTenants_XML() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    /**
     * Mètode que permet recuperar tots els llogaters en format JSON connectant-se a la API REST
     * @return llistat de llogaters
     * @throws ClientErrorException error al connectar-se
     */
    public Response listOfTenants_JSON() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }

    /**
     * Mètode que permet processar el token en format XML connectant-se a la API REST
     * @param requestEntity token
     * @return token processat
     * @throws ClientErrorException error al connectar-se
     */
    public Response processamentProva_XML(Object requestEntity) throws ClientErrorException {
        return webTarget.path("processarToken").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    /**
     * Mètode que permet processar el token en format JSON connectant-se a la API REST
     * @param requestEntity token
     * @return token processat
     * @throws ClientErrorException error al connectar-se
     */
    public Response processamentProva_JSON(Object requestEntity) throws ClientErrorException {
        return webTarget.path("processarToken").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }
    
    /**
     * Mètode que serveix per a eliminar el token de la API REST
     * @return elimina token
     * @throws ClientErrorException error al connectar-se
     */
    public Response removeToken() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("eliminarToken");
        return resource.request().delete(Response.class);
    }

    /**
     * Mètode per a tancar la comunicació amb la API REST
     */
    public void close() {
        client.close();
    }
    
}
