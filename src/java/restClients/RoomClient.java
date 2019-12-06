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
 * @author Sancho
 */
public class RoomClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RESTServiceForPract2SistemesOberts/webresources/";

    public RoomClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("room");
    }
    
    public Response findHabitacio(Integer id) throws ClientErrorException{
        WebTarget resource = webTarget.path(String.valueOf(id));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
    }

    public Response find_XML(String location, String sort) throws ClientErrorException {
        WebTarget resource = webTarget;
        System.out.println(location+" "+sort);
        /*resource = resource.queryParam("location", location).queryParam("sort", sort);
        System.out.println(resource.getUri().toString());
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();*/
        
        if (location != null) {
            resource = resource.queryParam("location", location);
        }
        if (sort != null) {
            resource = resource.queryParam("sort", sort);
        }
        System.out.println(resource.getUri().toString());
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get();
    }

    public Response find_JSON(String location, String sort) throws ClientErrorException {
        WebTarget resource = webTarget;
        
        System.out.println(location+" "+sort);
        
        resource = resource.queryParam("location", location).queryParam("sort", sort);
        System.out.println(resource.getUri().toString());
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        
    }

    public Response editHabitacio_XML(Object requestEntity, String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    public Response editHabitacio_JSON(Object requestEntity, String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response createHabitacio_XML(Object requestEntity) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    public Response createHabitacio_JSON(Object requestEntity) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response remove(String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
