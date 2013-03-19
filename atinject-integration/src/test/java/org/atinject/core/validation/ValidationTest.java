package org.atinject.core.validation;

import javax.inject.Inject;

import org.atinject.integration.IntegrationTest;
import org.junit.Test;

public class ValidationTest extends IntegrationTest
{

    @Inject Validator validator;
    
    @Inject ValidatedService validatedService;
    
    @Test
    public void testValidation(){
        validator.validate(new String());
    }
    
    @Test(expected=RuntimeException.class)
    public void testValidatedService(){
        try {
            validatedService.validateNotNull(null);
        }
        catch (RuntimeException e){
            throw e;
        }
        
    }
}
