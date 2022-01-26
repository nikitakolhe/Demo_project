package com.ugam1.core.models.impl;

import com.ugam1.core.models.Banner;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BannerImplTest {
    private final AemContext aemContext = new AemContext();
    private Banner banner;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/banner.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/banner");
        Banner banner = json.adaptTo(Banner.class);
        assertEquals("This is me", banner.getTitle());
    }

    @Test
    void getHeading() {
        Resource json = aemContext.currentResource("/content/banner");
        Banner banner = json.adaptTo(Banner.class);
        assertEquals("Philip Gilbert", banner.getHeading());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/banner");
        Banner banner = json.adaptTo(Banner.class);
        assertEquals("You will begin to realise why this exercise is called the Dickens Pattern with reference to the ghost showing Scrooge some different futures.", banner.getText());
    }

    @Test
    void getButton() {
        Resource json = aemContext.currentResource("/content/banner");
        Banner banner = json.adaptTo(Banner.class);
        assertEquals("discover now", banner.getButton());

    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/banner");
        Banner banner = json.adaptTo(Banner.class);
        assertEquals("/content/dam/ugam1/hero-img.png", banner.getImage());
    }

    @Test
    void getBannerAreaPathField() {
        Resource json = aemContext.currentResource("/content/banner");
        Banner banner = json.adaptTo(Banner.class);
        assertEquals("/content/ugam1/us/en/home", banner.getBannerAreaPathField());

    }
}