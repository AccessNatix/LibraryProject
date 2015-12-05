package com.libraryproject.utility;

import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Session bean for the user
 * 
 * 
 * @author anatole
 */
@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionBean {
    private final String id = UUID.randomUUID().toString();
}
