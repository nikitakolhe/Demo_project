package com.ugam1.core.models.Impl;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugam1.core.models.Timeline;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(
        adaptables = Resource.class,
        adapters = Timeline.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = TimelineImpl.RESOURCE_TYPE
)
@Exporters({
        @Exporter(name = "jackson", extensions = "json",
                options = {
                        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value = "true"),
                }),
        @Exporter(name = "xml", extensions = "xml",selector = "testimonial",
                options = {
                        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
                })


})
@JsonRootName("timeline")
@XmlRootElement(name = "xml-exporter")
public class TimelineImpl implements Timeline {

    final protected static String RESOURCE_TYPE="ugam1/components/content/timeline";

    private static final Logger LOG = LoggerFactory.getLogger(TimelineImpl.class);
    @ChildResource
    Resource timelinemulti;
    @Override
    public List<Map<String, String>> getTimeLineDetails() {
        List<Map<String, String>> timeLineMap=new ArrayList<>();
        //try {
        // Resource factAreaDetail=componentResource.getChild("factareamulti");
        if(timelinemulti!=null){
            for (Resource fact : timelinemulti.getChildren()) {
                Map<String,String> timelinearea=new HashMap<>();
                timelinearea.put("title",fact.getValueMap().get("title",String.class));
                timelinearea.put("year",fact.getValueMap().get("year",String.class));
                timelinearea.put("result",fact.getValueMap().get("result",String.class));
                timeLineMap.add(timelinearea);
            }
        }

        return timeLineMap;
    }
}

