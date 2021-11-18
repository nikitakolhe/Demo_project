package com.ugam1.core.models.Impl;


import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.crx.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "ugam1/components/page"
)
public class Resourcetypeservlet extends SlingAllMethodsServlet {


    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws IOException, IOException, IOException {

        final ResourceResolver resourceResolver = req.getResourceResolver();
        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/ugam1/us/en");
        List pagesList = new ArrayList();
        Iterator<Page> childPages = page.listChildren();
        while (childPages.hasNext()) {

            Page childPage = childPages.next();
            String pageName;
            pageName =childPage.getTitle();
            pagesList.add(pageName);
        }

        resp.setContentType("text/html");
        resp.getWriter().print(pagesList);
    }
}
