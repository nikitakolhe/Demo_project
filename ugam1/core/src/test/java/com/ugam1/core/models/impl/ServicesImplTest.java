package com.ugam1.core.models.impl;

import com.ugam1.core.models.Services;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class ServicesImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/Services.json", "/content");

    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/Services");
        Services services = json.adaptTo(Services.class);
        assertEquals("Web Design", services.getTitle());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/Services");
        Services services = json.adaptTo(Services.class);
        assertEquals("It is not because things are difficult that we do not dare; it is because we do not dare that they are difficult.", services.getText());
    }
}