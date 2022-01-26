package com.ugam1.core.models.impl;

import com.ugam1.core.models.Facts;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class FactsImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Facts.json", "/content");
    }

    @Test
    void getFactAreaDetails() {
        Resource json = aemContext.currentResource("/content/Facts");
         Facts facts = json.adaptTo(Facts.class);
        assertEquals("2536", facts.getFactAreaDetails().get(0).get("number"));
        assertEquals("Projects Completed", facts.getFactAreaDetails().get(0).get("text"));
    }
}