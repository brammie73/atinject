package org.atinject.core.distexec;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.atinject.core.cache.DistributedCache;
import org.atinject.core.cdi.Named;
import org.atinject.core.concurrent.AsynchronousService;
import org.infinispan.distexec.DefaultExecutorService;
import org.infinispan.distexec.DistributedExecutorService;

@ApplicationScoped
public class UserRequestDistributedExecutor {

    @Inject @Named("distributed-executor") private DistributedCache<UUID, Object> masterCacheNode;
    
    @Inject
    private AsynchronousService localExecutorService;

    private DistributedExecutorService distributedExecutorService;
    
    @PostConstruct
    public void initialize(){
        distributedExecutorService = new DefaultExecutorService(masterCacheNode.unwrap(), localExecutorService);
    }
    
    public <T> Future<T> submit(Callable<T> task, UUID input){
        return distributedExecutorService.submit(task, input);
    }
    
}
