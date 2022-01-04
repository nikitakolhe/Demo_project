package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Blog;
import com.ugam1.core.models.Footer;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class FooterImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/Footer.json", "/content");
    }

    @Test
    void getTitle1() {
        Resource json = aemContext.currentResource("/content/Footer");
        Footer footer = json.adaptTo(Footer.class);
        assertEquals("About me", footer.getTitle1());
    }

    @Test
    void getTitle2() {
        Resource json = aemContext.currentResource("/content/Footer");
        Footer footer = json.adaptTo(Footer.class);
        assertEquals("Newsletter", footer.getTitle2());
    }

    @Test
    void getTitle3() {Resource json = aemContext.currentResource("/content/Footer");
        Footer footer = json.adaptTo(Footer.class);
        assertEquals("Follow Me", footer.getTitle3());
    }

    @Test
    void getText1() {
        Resource json = aemContext.currentResource("/content/Footer");
        Footer footer = json.adaptTo(Footer.class);
        assertEquals("We have tested a number of registry fix and clean utilities and present our top 3 list on our site for your convenience", footer.getText1());
    }

    @Test
    void getText2() {
        Resource json = aemContext.currentResource("/content/Footer");
        Footer footer = json.adaptTo(Footer.class);
        assertEquals("Stay updated with our latest trends", footer.getText2());
    }

    @Test
    void getText3() {
        Resource json = aemContext.currentResource("/content/Footer");
        Footer footer = json.adaptTo(Footer.class);
        assertEquals("Let us be social", footer.getText3());
    }
}