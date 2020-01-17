/*
 * SINGLETON DEL SERVEI DE LES HABITACIONS
 */
package ServicesSingleton;
import restClients.RoomClient;
/**
 *
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */

public class RoomServiceSingleton {
    
    private static RoomServiceSingleton roomClientService = new RoomServiceSingleton();
    
    private RoomClient roomClient;
    
    /**
     * Constructor privat que genera el client
     */
    private RoomServiceSingleton(){
        roomClient = new RoomClient();
    }
    
    /**
     * Mètode static que permet recuperar la instància
     * @return instància
     */
    public static RoomServiceSingleton getInstance(){
        return roomClientService;
    }
    
    /**
     * Mètode que recupera el client REST
     * @return client
     */
    public RoomClient getService(){
        return roomClient;
    }
    
}
