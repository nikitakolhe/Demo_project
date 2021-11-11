package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Blog;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Blog.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class BlogImpl implements Blog {
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
