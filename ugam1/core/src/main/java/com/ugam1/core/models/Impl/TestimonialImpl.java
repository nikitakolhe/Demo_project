package com.ugam1.core.models.Impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugam1.core.models.Testimonial;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;
@Model(adaptables = Resource.class,
        adapters = Testimonial.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = TestimonialImpl.RESOURCE_TYPE
)
@Exporter(name = "jackson", extensions = "json",selector = "testimonial",
        options = {
        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
        })
@JsonRootName("testimonial")
public class TestimonialImpl implements Testimonial {
final protected static String RESOURCE_TYPE="ugam1/components/content/testimonial";
    @Inject
    String name;
    @Inject
    String desc;
    @Inject
    String desg;
    @JsonProperty(value = "name")

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
