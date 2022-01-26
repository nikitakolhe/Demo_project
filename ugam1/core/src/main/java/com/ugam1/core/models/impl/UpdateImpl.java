package com.ugam1.core.models.impl;


import com.day.cq.commons.date.DateUtil;
import com.ugam1.core.models.Update;
import com.ugam1.core.utils.ResolverUtil;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jcr.Node;
import javax.jcr.Session;
import java.util.Calendar;

@Component(service = Update.class,immediate = true)
public class UpdateImpl implements Update {
    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    final Logger LOG = LoggerFactory.getLogger(UpdateImpl.class);


    @Override
    public void update(String path){
        try{
            ResourceResolver serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Resource resource = serviceResourceResolver.getResource(path);
            Node node = resource.adaptTo(Node.class);
            node.setProperty("Time" , DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance())));
            session.save();
            session.logout();
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }

    }


}
