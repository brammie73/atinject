package org.atinject.core.authorization;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@RequiresGuest
@Interceptor
public class RequiresGuestInterceptor {
    
    @AroundInvoke
    public Object profile(InvocationContext invocationContext) throws Exception{
        return invocationContext.proceed();
    }
}
