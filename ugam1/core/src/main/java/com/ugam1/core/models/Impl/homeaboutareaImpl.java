package com.ugam1.core.models.Impl;

import com.ugam1.core.models.homeaboutarea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = homeaboutarea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class homeaboutareaImpl implements homeaboutarea{
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
    public String getBannerHeading() { return heading; }
    @Override
    public String getBannerTitle() { return title; }
    @Override
    public String getBannerText() { return text; }
    @Override
    public String getBannerButton() { return button; }

    @Override
    public String getImage() {
        return image;
    }

}
