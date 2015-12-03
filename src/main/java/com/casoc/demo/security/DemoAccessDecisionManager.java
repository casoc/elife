package com.casoc.demo.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

import java.util.Collection;

public class DemoAccessDecisionManager implements AccessDecisionManager {
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

    }

    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    public boolean supports(Class<?> aClass) {
        return false;
    }
}
