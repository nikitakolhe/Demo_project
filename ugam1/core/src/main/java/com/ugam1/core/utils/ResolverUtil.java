package com.ugam1.core.utils;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

public class ResolverUtil {
    private ResolverUtil(){

    }

    public static final String UGAM1_SERVICE_USER = "ugam1serviceuser";
    public static ResourceResolver newResolver(ResourceResolverFactory resourceResolverFactory) throws LoginException, org.apache.sling.api.resource.LoginException {
        final Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put(ResourceResolverFactory.SUBSERVICE, UGAM1_SERVICE_USER);
        ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(paramMap);
        return resolver;
    }





}
