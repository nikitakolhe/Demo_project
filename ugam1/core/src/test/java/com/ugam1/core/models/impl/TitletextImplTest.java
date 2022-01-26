package com.ugam1.core.models.impl;

import com.ugam1.core.models.Titletext;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class TitletextImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/Titletext.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/Titletext");
        Titletext titletext = json.adaptTo(Titletext.class);
        assertEquals("My Offered Services", titletext.getTitle());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/Titletext");
        Titletext titletext = json.adaptTo(Titletext.class);
        assertEquals("At about this time of year, some months after New Year’s resolutions have been made and kept, or made and neglected.", titletext.getText());
    }

    @Test
    void getPaddingBottom() {
        Resource json = aemContext.currentResource("/content/Titletext");
        Titletext titletext = json.adaptTo(Titletext.class);
        assertEquals(false, titletext.getPaddingBottom());
    }

    @Test
    void getSectionGap() {
        Resource json = aemContext.currentResource("/content/Titletext");
        Titletext titletext = json.adaptTo(Titletext.class);
        assertEquals(true, titletext.getSectionGap());
    }

}