/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesSingleton;
import restClients.AutenticacioClient;
/**
 *
 * @author Cesc
 */
public class AutenticacioServiceSingleton {
    
    private static AutenticacioServiceSingleton serveiAutenticacio = new AutenticacioServiceSingleton();
    
    private AutenticacioClient autenticacioClientServei;
    
    private AutenticacioServiceSingleton(){autenticacioClientServei = new AutenticacioClient();}
    
    public static AutenticacioServiceSingleton getInstance(){
        return serveiAutenticacio;
    }
    
    public AutenticacioClient getServeiAutenticacio(){
        return autenticacioClientServei;
    }
    
    
    
}
