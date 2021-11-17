package com.ugam1.core.models.Impl;

import com.ugam1.core.models.Pricearea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(AemContextExtension.class)
class PathtypeservletTest {
   // private final AemContext aemContext = new AemContext();
    private Pathtypeservlet pathtypeservlet = new Pathtypeservlet();

    @BeforeEach
    void setUp() throws ServletException,IOException {
    }

    @Test
    void doGet(AemContext context) throws ServletException, IOException {
        MockSlingHttpServletRequest request = context.request();
        MockSlingHttpServletResponse response = context.response();
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("number1", 11);
        parameterMap.put("number2", 11);
        request.setParameterMap(parameterMap);
        pathtypeservlet.doGet(request, response);
        //int result =  Integer.parseInt(mockSlingResponse.getOutputAsString());
        assertEquals(22,Integer.parseInt(response.getOutputAsString()));
    }
}