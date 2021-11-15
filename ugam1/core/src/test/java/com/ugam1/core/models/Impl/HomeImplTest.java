package com.ugam1.core.models.Impl;

import com.ugam1.core.models.HomeAbout;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class HomeImplTest {
    private final AemContext aemContext = new AemContext();
    private HomeAbout homeAbout;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Homeaboutarea.json", "/content");
    }

    @Test
    void getHeading() {
        Resource json = aemContext.currentResource("/content/home");
        HomeAbout homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("Personal Details", homeAbout.getHeading());
    }

   @Test
    void getTitle() {
       Resource json = aemContext.currentResource("/content/home");
       HomeAbout homeAbout = json.adaptTo(HomeAbout.class);
       assertEquals("About Me", homeAbout.getTitle());
    }

   @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/home");
        HomeAbout homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("Here, I focus on a range of items and features that we use in life without giving them a second thought. such as Coca Cola. Dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.",
                homeAbout.getText());
    }

    @Test
    void getButton() {
        Resource json = aemContext.currentResource("/content/home");
        HomeAbout homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("View Full Details", homeAbout.getButton());
    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/home");
        HomeAbout homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("/content/dam/ugam1/about-img - Copy.png", homeAbout.getImage());
    }

  /* @Test
    void getHomeAreaPathField() {
        Resource json = aemContext.currentResource("/content/home");
        HomeAbout homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("/content/ugam1/us/en/about", homeAbout.getHomeAreaPathField());
    }*/
}