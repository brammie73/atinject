package org.atinject.core.cdi;

import org.atinject.core.transaction.InMemoryTransactionServices;
import org.jboss.weld.bootstrap.api.Bootstrap;
import org.jboss.weld.bootstrap.spi.Deployment;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.resources.spi.ResourceLoader;
import org.jboss.weld.transaction.spi.TransactionServices;

public class JavaSECDIProvider {

    private final Weld weld;
    private final WeldContainer weldContainer;
    
    public JavaSECDIProvider(){
        weld = new Weld(){
            @Override
            protected Deployment createDeployment(ResourceLoader resourceLoader, Bootstrap bootstrap)
            {
                Deployment deployment = super.createDeployment(resourceLoader, bootstrap);
                deployment.getServices().add(TransactionServices.class, new InMemoryTransactionServices());
                return deployment;
            }
        };
        weldContainer = weld.initialize();
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){
            @Override
            public void run() {
                weld.shutdown();
            }}));
    }
    
}
