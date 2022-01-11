package com.ugam1.core.models.impl;
import com.ugam1.core.models.HomeAbout;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import javax.inject.Inject;


@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = HomeImpl.RESOURCE_TYPE
)

public class HomeImpl implements HomeAbout{

    final  static String RESOURCE_TYPE="ugam1/components/content/homeaboutarea";
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
}
