package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Blog;
import com.ugam1.core.models.Portfolio;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class PortfolioImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/Portfolio.json", "/content");
    }

    @Test
    void getImagePath() {
        Resource json = aemContext.currentResource("/content/Portfolio");
        Portfolio portfolio = json.adaptTo(Portfolio.class);
        assertEquals("/content/dam/ugam1/p1.jpg", portfolio.getImagePath());
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/Portfolio");
        Portfolio portfolio = json.adaptTo(Portfolio.class);
        assertEquals("2D Vinyl Design", portfolio.getTitle());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/Portfolio");
        Portfolio portfolio = json.adaptTo(Portfolio.class);
        assertEquals("vector", portfolio.getText());
    }

    @Test
    void getPreview() {Resource json = aemContext.currentResource("/content/Portfolio");
        Portfolio portfolio = json.adaptTo(Portfolio.class);
        assertEquals("/content/dam/ugam1/preview.png", portfolio.getPreview());
    }
}