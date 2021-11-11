package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Portfolio;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Portfolio.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class PortfolioImpl implements Portfolio {
    @Inject
    String imagePath;
    @Inject
    String title;
    @Inject
    String text;
    @Inject
    String preview;

    @Override
    public String getImagePath() {
        return imagePath;
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
    public String getPreview() {
        return preview;
    }
}
