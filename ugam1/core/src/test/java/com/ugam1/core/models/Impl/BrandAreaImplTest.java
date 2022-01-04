package com.ugam1.core.models.Impl;

import com.day.cq.mcm.api.Brand;
import com.ugam1.core.models.BannerNav;
import com.ugam1.core.models.BrandArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class BrandAreaImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Brand.json", "/content");

    }

    @Test
    void getImgPath() {
        Resource json = aemContext.currentResource("/content/brand");
        BrandArea brandArea = json.adaptTo(BrandArea.class);
        assertEquals("/content/dam/ugam1/l1.png", brandArea.getImgPath().get(0));

    }
    @Test
    void empty() {
        Resource json = aemContext.currentResource("/content/empty");
        BrandArea brandArea = json.adaptTo(BrandArea.class);
        assertEquals(Collections.emptyList(), brandArea.getImgPath());}
}