/*
 * CLIENT REST PER A LES HABITACIONS
 */
package restClients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:HabitacioFacadeREST
 * [/room]<br>
 * USAGE:
 * <pre>
 *        RoomClient client = new RoomClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @authors Aleix Sancho i Francesc Ferré
 */
public class RoomClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RESTServiceForPract2SistemesOberts/webresources/";

    /**
     * Constructor
     */
    public RoomClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("room");
    }
    
    /**
     * Mètode que retorna totes les habitacions en format JSON de la API REST
     * @param criterion criteri
     * @return totes les habitacions
     * @throws ClientErrorException error al connectar-se
     */
    public Response findAllHabtacions(String criterion) throws ClientErrorException{
        WebTarget resource = webTarget.path("allRooms");
        resource.path(criterion);
        resource = resource.queryParam("sort", criterion);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    }
    
    /**
     * Mètode que retorna una habitacio donada una id, la recupera de la API REST
     * @param id id habitacio
     * @return habitació
     * @throws ClientErrorException error al connectar-se
     */
    public Response findHabitacio(Integer id) throws ClientErrorException{
        WebTarget resource = webTarget.path(String.valueOf(id));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
    }

    /**
     * Mètode que permet recuperar les habitacions donada la localitzacio i el criteri d'ordenament, ho recupera de la API REST, en format XML
     * @param location ciutat
     * @param sort criteri
     * @return totes les habitacions o nomes les habitacions de la ciutat en específic
     * @throws ClientErrorException error al connectar-se
     */
    public Response find_XML(String location, String sort) throws ClientErrorException {
        WebTarget resource = webTarget;
        System.out.println(location+" "+sort);
        
        
        if (location != null) {
            resource = resource.queryParam("location", location);
        }
        if (sort != null) {
            resource = resource.queryParam("sort", sort);
        }
        System.out.println(resource.getUri().toString());
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    /**
     * Mètode que permet recuperar les habitacions donada la localitzacio i el criteri d'ordenament, ho recupera de la API REST, en format JSON
     * @param location ciutat
     * @param sort criteri
     * @return totes les habitacions o nomes les habitacions de la ciutat en específic
     * @throws ClientErrorException error al connectar-se
     */
    public Response find_JSON(String location, String sort) throws ClientErrorException {
        WebTarget resource = webTarget;
        
        System.out.println(location+" "+sort);
        
        resource = resource.queryParam("location", location).queryParam("sort", sort);
        System.out.println(resource.getUri().toString());
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        
    }

    /**
     * Mètode per a tancar la comunicació amb la api REST
     */
    public void close() {
        client.close();
    }
    
}
