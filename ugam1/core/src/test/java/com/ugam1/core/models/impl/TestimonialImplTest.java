package com.ugam1.core.models.impl;

import com.ugam1.core.models.Testimonial;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class TestimonialImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Testimonial.json", "/content");

    }

    @Test
    void getName() {
        Resource json = aemContext.currentResource("/content/Testimonial");
        Testimonial testimonial = json.adaptTo(Testimonial.class);
        assertEquals("Harriet Maxwell", testimonial.getName());
    }

    @Test
    void getDesc() {
        Resource json = aemContext.currentResource("/content/Testimonial");
        Testimonial testimonial = json.adaptTo(Testimonial.class);
        assertEquals("Do you want to be even more successful? Learn to love learning and growth. The more effort you put into improving your skills, the bigger the payoff you.", testimonial.getDesc());
    }

    @Test
    void getDesg() {
        Resource json = aemContext.currentResource("/content/Testimonial");
        Testimonial testimonial = json.adaptTo(Testimonial.class);
        assertEquals("CEO at Google", testimonial.getDesg());
    }
}