package org.atinject.core.websocket.dto;

import java.util.UUID;

import org.atinject.core.dto.DTO;

public abstract class WebSocketResponse extends DTO
{
    private static final long serialVersionUID = 1L;

    private UUID requestId;
    
    private WebSocketResponseException exception;
    
    public WebSocketResponse(){
        super();
    }

    public UUID getRequestId()
    {
        return requestId;
    }

    public WebSocketResponse setRequestId(UUID requestId)
    {
        this.requestId = requestId;
        return this;
    }

    public WebSocketResponseException getException()
    {
        return exception;
    }

    public WebSocketResponse setException(WebSocketResponseException exception)
    {
        this.exception = exception;
        return this;
    }
    
}
