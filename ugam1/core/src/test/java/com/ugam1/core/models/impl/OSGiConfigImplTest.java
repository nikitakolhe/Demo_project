package com.ugam1.core.models.impl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class OSGiConfigImplTest {
    private final AemContext aemContext = new AemContext();
    private String[] country={"us","in"};
    OSGiConfigImpl osGiConfig;
    @BeforeEach
    void setUp()  {
        osGiConfig = aemContext.registerService(new OSGiConfigImpl());
        OSGiConfigImpl.ServiceConfig config = mock(OSGiConfigImpl.ServiceConfig.class);
        when(config.serviceName()).thenReturn("UGAM1 Service");
        when(config.getCount()).thenReturn(986);
        when(config.getCountries()).thenReturn(country);
        osGiConfig.activate(config);

    }

    @Test
    void activate() {
    }

    @Test
    void getServiceName() {
        assertEquals("UGAM1 Service", osGiConfig.getServiceName());

    }


    @Test
    void getServiceCount() {
        assertEquals(986, osGiConfig.getServiceCount());
    }

    @Test
    void getCountries() {

        assertEquals(country,osGiConfig.getCountries());


    }

}