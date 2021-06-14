package com.ugam1.core.models.Impl;

import com.ugam1.core.models.facts;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
@Model(adaptables = Resource.class,
        adapters = facts.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class factsImpl implements facts {
    @Inject
    String title;
    @Inject
    String text;
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }
}
