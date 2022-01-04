package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Titletext;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Titletext.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TitletextImpl implements Titletext {
    @Inject
    String title;
    @Inject
    String text;
    @Inject
    Boolean paddingbottom;
    @Inject
    Boolean sectiongap;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Boolean getPaddingBottom() {
        return paddingbottom;
    }

    @Override
    public Boolean getSectionGap() {
        return sectiongap;
    }



}