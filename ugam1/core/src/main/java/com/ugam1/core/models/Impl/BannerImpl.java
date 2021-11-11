package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Banner;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Banner.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class BannerImpl implements Banner {
    @Inject
    String title;
    @Inject
    String heading;
    @Inject
    String text;
    @Inject
    String button;
    @Inject
    String image;
    @Inject
    String path;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getHeading() {
        return heading;
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
    public String getBannerAreaPathField() { return path; }

}
