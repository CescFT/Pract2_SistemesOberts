/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesSingleton;
import restClients.RoomClient;
/**
 *
 * @author Cesc
 */

public class RoomServiceSingleton {
    
    private static RoomServiceSingleton roomClientService = new RoomServiceSingleton();
    
    private RoomClient roomClient;
    
    private RoomServiceSingleton(){
        roomClient = new RoomClient();
    }
    
    public static RoomServiceSingleton getInstance(){
        return roomClientService;
    }
    
    public RoomClient getService(){
        return roomClient;
    }
    
}
