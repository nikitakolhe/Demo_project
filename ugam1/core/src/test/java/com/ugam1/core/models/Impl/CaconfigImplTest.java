package com.ugam1.core.models.Impl;

import com.day.cq.wcm.api.Page;
import com.ugam1.core.config.Ugam1CAConfig;
import com.ugam1.core.models.Caconfig;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class CaconfigImplTest {
    AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    CaconfigImpl caconfig;
    private String siteCountry;
    private String siteLocale;
    private String siteAdmin;
    private String siteSection;
    Page currentPage;
    ConfigurationBuilder configurationBuilder = mock(ConfigurationBuilder.class);
    ResourceResolver resourceResolver = mock(ResourceResolver.class);
    Resource contentResource = mock(Resource.class);

    @BeforeEach
    void setUp() throws NoSuchFieldException{

        caconfig=aemContext.registerService(new CaconfigImpl());
        Ugam1CAConfig caConfig = mock(Ugam1CAConfig.class);

        lenient().when(caConfig.siteAdmin()).thenReturn("Admin1");
        lenient().when(caConfig.siteCountry()).thenReturn("Country1");
        lenient().when(caConfig.siteSection()).thenReturn("Section");
        lenient().when(caConfig.siteLocale()).thenReturn("Locale");

        currentPage = aemContext.create().page("/content/ugam1/us/en");
        String currentPath = "/content/ugam1/us/en";
        PrivateAccessor.setField(caconfig,"currentPage",currentPage);
        PrivateAccessor.setField(caconfig,"resourceResolver",resourceResolver);
        when(resourceResolver.getResource(currentPath)).thenReturn(contentResource);
        when(contentResource.adaptTo(ConfigurationBuilder.class)).thenReturn(configurationBuilder);
        when(configurationBuilder.as(Ugam1CAConfig.class)).thenReturn(caConfig);
        caconfig.postConstruct();



    }

    @Test
    void getSiteCountry() {
        assertEquals("Country1",caconfig.getSiteCountry());
    }

    @Test
    void getSiteLocale() {
        assertEquals("Locale",caconfig.getSiteLocale());
    }

    @Test
    void getSiteAdmin() {
        assertEquals("Admin1",caconfig.getSiteAdmin());
    }

    @Test
    void getSiteSection() {
        assertEquals("Section",caconfig.getSiteSection());
    }

}