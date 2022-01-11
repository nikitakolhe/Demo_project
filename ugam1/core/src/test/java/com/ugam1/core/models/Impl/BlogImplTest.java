package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Banner;
import com.ugam1.core.models.Blog;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class BlogImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
            aemContext.load().json("/Blog.json", "/content");

    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/Blog");
        Blog blog = json.adaptTo(Blog.class);
        assertEquals("/content/dam/ugam1/b1.jpg", blog.getImage());

    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/Blog");
        Blog blog = json.adaptTo(Blog.class);
        assertEquals("Break Through Self Doubt And Fear", blog.getTitle());

    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/Blog");
        Blog blog = json.adaptTo(Blog.class);
        assertEquals("Dream interpretation has many forms; it can be done be done for the sake of fun, hobby or can be taken up as a serious career.", blog.getText());
    }
}