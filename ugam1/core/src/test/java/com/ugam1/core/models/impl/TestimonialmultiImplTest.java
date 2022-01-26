package com.ugam1.core.models.impl;

import com.ugam1.core.models.Testimonialmulti;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class TestimonialmultiImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Testimonialmulti.json", "/content");


    }

    @Test
    void getTestimonialMulti() {
        Resource json = aemContext.currentResource("/content/Testimonialmulti");
        Testimonialmulti testimonialmulti = json.adaptTo(Testimonialmulti.class);
        assertEquals("my", testimonialmulti.getTestimonialMulti().get(0).get("name"));
        assertEquals("testimonial", testimonialmulti.getTestimonialMulti().get(0).get("desg"));
        assertEquals("multi", testimonialmulti.getTestimonialMulti().get(0).get("desc"));
    }
}