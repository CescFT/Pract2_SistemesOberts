/*
 * SINGLETON DEL SERVEI DE L'AUTENTICACIÓ
 */
package ServicesSingleton;
import restClients.AutenticacioClient;
/**
 *
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public class AutenticacioServiceSingleton {
    
    private static AutenticacioServiceSingleton serveiAutenticacio = new AutenticacioServiceSingleton();
    
    private AutenticacioClient autenticacioClientServei;
    
    /**
     * Constructor privat que genera el client
     */
    private AutenticacioServiceSingleton(){autenticacioClientServei = new AutenticacioClient();}
    
    /**
     * Mètode static que permet recuperar la instància
     * @return instància
     */
    public static AutenticacioServiceSingleton getInstance(){
        return serveiAutenticacio;
    }
    
    /**
     * Mètode que recupera el client REST
     * @return client
     */
    public AutenticacioClient getServeiAutenticacio(){
        return autenticacioClientServei;
    }
    
}
