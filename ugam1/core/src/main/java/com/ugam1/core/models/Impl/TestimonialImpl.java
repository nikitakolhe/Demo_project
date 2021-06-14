package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Testimonial;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
@Model(adaptables = Resource.class,
        adapters = Testimonial.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class TestimonialImpl implements Testimonial {

    @Inject
    String name;
    @Inject
    String desc;
    @Inject
    String desg;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getDesg() {
        return desg;
    }

}
