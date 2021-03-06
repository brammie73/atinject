package org.atinject.core.tiers;

import org.atinject.core.profiling.Profile;
import org.atinject.core.thread.ThreadTracker;
import org.atinject.core.tiers.exception.HandleWebSocketServiceException;
import org.atinject.core.transaction.Transactional;
import org.atinject.core.validation.ValidateRequest;

//TODO use stereotype instead
@HandleWebSocketServiceException
@Profile
@ThreadTracker
@Transactional
@ValidateRequest
public abstract class WebSocketService {


}
