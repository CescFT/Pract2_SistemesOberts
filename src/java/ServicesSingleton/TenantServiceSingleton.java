/*
 * SINGLETON DEL SERVEI DEL LLOGATER
 */
package ServicesSingleton;
import restClients.TenantClient;
/**
 *
 * @authors Francesc Ferré Tarrés i Aleix Sancho Pujals
 */
public class TenantServiceSingleton {
    
    private static TenantServiceSingleton tenantService = new TenantServiceSingleton();
    
    private TenantClient tenantClientService;
    
    /**
     * Constructor privat que genera el client
     */
    private TenantServiceSingleton(){tenantClientService = new TenantClient();}
    
    /**
    * Mètode static que permet recuperar la instància
    * @return instància
    */
    public static TenantServiceSingleton getInstance(){
        return tenantService;
    }
    
    /**
     * Mètode que recupera el client REST
     * @return client
     */
    public TenantClient getTenantService(){
        return tenantClientService;
    }
    
}
