package com.ugam1.core.models.impl;

import com.ugam1.core.models.Apiosgi;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = Apiosgi.class,immediate = true)
@Designate(ocd = ApiosgiImpl.ServiceConfigs.class)
public class ApiosgiImpl implements Apiosgi {
    @ObjectClassDefinition(name="UGAM1 - ApiOSGi Config",
            description ="apiOsgi")
    public @interface ServiceConfigs{

        @AttributeDefinition(
                name = "URL",
                description = "Enter Service name",
                type = AttributeType.STRING)
        String getUrl() default "https://reqres.in/api/users/";

        @AttributeDefinition(
                name = "URL",
                description = "Enter Service name",
                type = AttributeType.STRING)
        String getmultiUrl() default "https://reqres.in/api/users/";


    }

    private String url;
    private String multiurl;
    @Activate
    public void activate(ApiosgiImpl.ServiceConfigs serviceConfigs){
        url=serviceConfigs.getUrl();

    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getmultiUrl() {
        return multiurl;
    }



}
