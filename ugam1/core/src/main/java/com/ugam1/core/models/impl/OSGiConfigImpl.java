package com.ugam1.core.models.impl;


import com.ugam1.core.models.OSGiConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.*;

@Component(service = OSGiConfig.class,immediate = true)
@Designate(ocd = OSGiConfigImpl.ServiceConfig.class)
public class OSGiConfigImpl implements OSGiConfig {

    @ObjectClassDefinition(name="UGAM1 - OSGi Config",
    description ="Osgi")
    public @interface ServiceConfig{

        @AttributeDefinition(
                name = "Service Name",
                description = "Enter Service name",
                type = AttributeType.STRING)
         String serviceName() default "UGAM1 Service";


        @AttributeDefinition(
                name = "Service Count",
                description = "Add Service Count",
                type = AttributeType.INTEGER)
        int getCount() default 14;


        @AttributeDefinition(
                name = "Countries",
                description = "Add Countries",
                type = AttributeType.STRING)
        String[] getCountries() default {"in","dia"} ;


    }




    private String serviceName;
    private int serviceCount;
    private String[] countries;

    @Activate
    public void activate(ServiceConfig serviceConfig){
        serviceName=serviceConfig.serviceName();
        serviceCount=serviceConfig.getCount();
        countries=serviceConfig.getCountries();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
    @Override
    public int getServiceCount() {
        return serviceCount;
    }

    @Override
    public String[] getCountries() {
        return countries;
    }

}


