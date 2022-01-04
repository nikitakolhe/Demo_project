package com.ugam1.core.models.Impl;

import com.day.cq.wcm.api.Page;
import com.ugam1.core.config.Ugam1CAConfig;
import com.ugam1.core.models.Caconfig;
import com.ugam1.core.models.Caconfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.caconfig.ConfigurationResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.*;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Caconfig.class,
        //resourceType = {CaconfigImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)


public class CaconfigImpl implements Caconfig {
    private static final Logger LOG = LoggerFactory.getLogger(CaconfigImpl.class);
  // protected static final String RESOURCE_TYPE = "";


    @SlingObject
    ResourceResolver resourceResolver;
    @ScriptVariable
    Page currentPage;

    private String siteCountry;
    private String siteLocale;
    private String siteAdmin;
    private String siteSection;

    @Override
    public String getSiteCountry() {
        return siteCountry;
    }

    @Override
    public String getSiteLocale() {
        return siteLocale;
    }

    @Override
    public String getSiteAdmin() {
        return siteAdmin;
    }

    @Override
    public String getSiteSection() {
        return siteSection;
    }


    @PostConstruct
    public void postConstruct() {
        Ugam1CAConfig caConfig = getContextAwareConfig(currentPage.getPath(), resourceResolver);

        siteCountry = caConfig.siteCountry();
        siteLocale = caConfig.siteLocale();
        siteAdmin = caConfig.siteAdmin();
        siteSection = caConfig.siteSection();

    }

    public Ugam1CAConfig getContextAwareConfig(String currentPage, ResourceResolver resourceResolver) {
        String currentPath = StringUtils.isNoneBlank(currentPage) ? currentPage : StringUtils.EMPTY;
        Resource contentResource = resourceResolver.getResource(currentPath);
        if (contentResource != null) {
            ConfigurationBuilder configurationBuilder = contentResource.adaptTo(ConfigurationBuilder.class);
            if (configurationBuilder != null) {
                return configurationBuilder.as(Ugam1CAConfig.class);
            }
        }

return null;
    }

}
