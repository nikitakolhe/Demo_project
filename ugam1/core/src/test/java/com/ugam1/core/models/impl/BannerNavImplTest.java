package com.ugam1.core.models.impl;

import com.ugam1.core.models.BannerNav;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class BannerNavImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {

        aemContext.load().json("/BannerNav.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/BannerNav");
        BannerNav bannerNav = json.adaptTo(BannerNav.class);
        assertEquals("About Me", bannerNav.getTitle());
    }

    @Test
    void getNav1() {
        Resource json = aemContext.currentResource("/content/BannerNav");
        BannerNav bannerNav = json.adaptTo(BannerNav.class);
        assertEquals("home", bannerNav.getNav1());
    }

    @Test
    void getNav2() {
        Resource json = aemContext.currentResource("/content/BannerNav");
        BannerNav bannerNav = json.adaptTo(BannerNav.class);
        assertEquals("about me", bannerNav.getNav2());
    }
}