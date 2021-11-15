package com.ugam1.core.models.Impl;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugam1.core.models.Blog;
import com.ugam1.core.models.Pricearea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Pricearea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,

        resourceType = PriceareaImpl.RESOURCE_TYPE
)
@Exporter(name = "jackson", extensions = "json",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
        })
@JsonRootName("pricearea")
public class PriceareaImpl implements Pricearea {
    final protected static String RESOURCE_TYPE="ugam1/components/content/pricearea";
    @Inject
    String type;
    @Inject
    String num;
    @Inject
    String title;
    @Inject
    String text1;
    @Inject
    String text2;
    @Inject
    String text3;

    @Override
    public String getPriceType() {
        return type;
    }

    @Override
    public String getPriceTitle() {
        return title;
    }

    @Override
    public String getPriceNumber() {
        return num;
    }

    @Override
    public String getPriceText1() {
        return text1;
    }

    @Override
    public String getPriceText2() {
        return text2;
    }

    @Override
    public String getPriceText3() {
        return text3;
    }
}
