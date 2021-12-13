package com.ugam1.core.models.Impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugam1.core.models.Testimonial;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRootElement;

@Model(adaptables = Resource.class,
        adapters = Testimonial.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = TestimonialImpl.RESOURCE_TYPE
)
@Exporters({
        @Exporter(name = "jackson", extensions = "json", selector = "testimonial",
                options = {
                        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value = "true"),
                }),
        @Exporter(name = "xml", extensions = "xml",selector = "testimonial",
                options = {
                        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
                })

})
@JsonRootName("testimonial")
@XmlRootElement(name = "xml-exporter")
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
