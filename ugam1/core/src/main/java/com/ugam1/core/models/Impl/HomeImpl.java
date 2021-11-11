package com.ugam1.core.models.Impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugam1.core.models.HomeAbout;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = HomeImpl.RESOURCE_TYPE
)
@Exporter(name = "jackson", extensions = "json",selector = "home",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
        })
@JsonRootName("home")
public class HomeImpl implements HomeAbout{

    final protected static String RESOURCE_TYPE="ugam1/components/content/homeaboutarea";
@JsonProperty(value = "heading")
    @Inject
    String heading;
    @Inject
    String title;
    @Inject
    String text;
    @Inject
    String button;
    @Inject
    String image;
    @Inject
    String path;

    @Override
    public String getHeading() {
        return heading;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getButton() {
        return button;
    }
    @Override
    public String getImage() {
        return image;
    }
    @Override
    public String getHomeAreaPathField() { return path; }
}
