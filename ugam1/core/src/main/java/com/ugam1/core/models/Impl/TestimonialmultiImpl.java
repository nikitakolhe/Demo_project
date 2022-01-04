package com.ugam1.core.models.Impl;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import com.ugam1.core.models.Testimonialmulti;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = Testimonialmulti.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL

)
public class TestimonialmultiImpl implements Testimonialmulti{
    @ChildResource
    Resource multitext;
    @Override
    public List<Map<String, String>> getTestimonialMulti() {
        List<Map<String, String>> testimonialAreaMap = new ArrayList<>();
        if (multitext != null) {
            for (Resource fact : multitext.getChildren()) {
                Map<String, String> testimonialMap = new HashMap<>();
                testimonialMap.put("name", fact.getValueMap().get("name", String.class));
                testimonialMap.put("desc", fact.getValueMap().get("desc", String.class));
                testimonialMap.put("desg", fact.getValueMap().get("desg", String.class));
                testimonialAreaMap.add(testimonialMap);
            }
        }
        return testimonialAreaMap;
    }

}
