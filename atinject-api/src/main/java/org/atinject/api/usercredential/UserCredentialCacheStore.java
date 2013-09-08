package org.atinject.api.usercredential;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.atinject.api.usercredential.entity.UserCredentialEntity;
import org.atinject.core.cache.CacheName;
import org.atinject.core.cache.ClusteredCache;

@ApplicationScoped
public class UserCredentialCacheStore {

    @Inject @CacheName("user-credential") ClusteredCache<String, UserCredentialEntity> cache;
    
    public UserCredentialEntity getUserCredential(String username) {
        return cache.get(username);
    }

    public void lock(String username) {
        cache.lock(username);
    }
    
    public void put(UserCredentialEntity userCredential){
        cache.put(userCredential.getUsername(), userCredential);
    }
    
    public void remove(UserCredentialEntity userCredential){
        cache.remove(userCredential.getUsername());
    }
    
}