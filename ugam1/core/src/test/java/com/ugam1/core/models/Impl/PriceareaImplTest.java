package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Pricearea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PriceareaImplTest {
    private final AemContext aemContext = new AemContext();
    private Pricearea pricearea;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Pricearea.json", "/content");
    }

    @Test
    void getPriceType() {
        Resource json = aemContext.currentResource("/content/price");
        Pricearea pricearea = json.adaptTo(Pricearea.class);
        assertEquals("Economy", pricearea.getPriceType());

    }

    @Test
    void getPriceTitle() {
        Resource json = aemContext.currentResource("/content/price");
        Pricearea pricearea = json.adaptTo(Pricearea.class);
        assertEquals("For the individuals", pricearea.getPriceTitle());
    }

    @Test
    void getPriceNumber() {
        Resource json = aemContext.currentResource("/content/price");
        Pricearea pricearea = json.adaptTo(Pricearea.class);
        assertEquals("01", pricearea.getPriceNumber());

    }

    @Test
    void getPriceText1() {
        Resource json = aemContext.currentResource("/content/price");
        Pricearea pricearea = json.adaptTo(Pricearea.class);
        assertEquals("Secure Online Transfer", pricearea.getPriceText1());
    }

    @Test
    void getPriceText2() {
        Resource json = aemContext.currentResource("/content/price");
        Pricearea pricearea = json.adaptTo(Pricearea.class);
        assertEquals("Unlimited Styles for interface", pricearea.getPriceText2());
    }

    @Test
    void getPriceText3() {
        Resource json = aemContext.currentResource("/content/price");
        Pricearea pricearea = json.adaptTo(Pricearea.class);
        assertEquals("Reliable Customer Service", pricearea.getPriceText3());
    }
}