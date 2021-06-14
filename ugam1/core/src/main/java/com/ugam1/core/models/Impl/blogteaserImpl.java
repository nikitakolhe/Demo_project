package com.ugam1.core.models.Impl;

import com.ugam1.core.models.blogteaser;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
@Model(adaptables = Resource.class,
        adapters = blogteaser.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class blogteaserImpl implements blogteaser {
    @Inject
    String image;
    @Inject
    String title;
    @Inject
    String text;

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }
}
