package com.ugam1.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Scheduler Configuration",description = "Sling scheduler configuration")
public @interface SchedulerConfiguration {
    @AttributeDefinition(
            name = "Scheduler name",
            description = "Name of the scheduler",
            type = AttributeType.STRING)
    public String schedulerName() default "Custom Sling Scheduler Configuration";

    @AttributeDefinition(name = "My Cron Expression", description = "My Cron Expression", type = AttributeType.STRING)
    public String time() default "0/20 * * * * ?";

}