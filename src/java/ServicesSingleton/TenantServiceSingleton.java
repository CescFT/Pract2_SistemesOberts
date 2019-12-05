/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesSingleton;
import restClients.TenantClient;
/**
 *
 * @author Cesc
 */
public class TenantServiceSingleton {
    
    private static TenantServiceSingleton tenantService = new TenantServiceSingleton();
    
    private TenantClient tenantClientService;
    
    private TenantServiceSingleton(){tenantClientService = new TenantClient();}
    
    public static TenantServiceSingleton getInstance(){
        return tenantService;
    }
    
    public TenantClient getTenantService(){
        return tenantClientService;
    }
    
}
