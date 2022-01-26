package com.ugam1.core.models.impl;

import com.ugam1.core.models.OSGiConfig;
import com.ugam1.core.models.OSGiConfigDemo;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = OSGiConfigDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class OSGiConfigDemoImpl implements  OSGiConfigDemo {

    @OSGiService
    OSGiConfig oSGiConfig;

    @Override
    public String getServiceName(){
        return oSGiConfig.getServiceName();
    }

    @Override
    public int getServiceCount(){
        return oSGiConfig.getServiceCount();
    }

    @Override
    public String[] getCountries(){
        return oSGiConfig.getCountries();
    }

}
