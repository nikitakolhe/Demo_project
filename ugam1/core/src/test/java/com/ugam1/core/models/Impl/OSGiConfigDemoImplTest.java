package com.ugam1.core.models.Impl;

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

class OSGiConfigDemoImplTest {
    private final AemContext aemContext = new AemContext();
    OSGiConfigImpl osgiConfig;
    private String serviceName;
    private int servicecount;
    private String[] country={"us","in"};


    @BeforeEach
    void setUp() {
        osgiConfig=aemContext.registerService(new OSGiConfigImpl());
        OSGiConfigImpl.ServiceConfig config = mock(OSGiConfigImpl.ServiceConfig.class);
        when(config.serviceName()).thenReturn("UGAM1 Service");
        when(config.getCount()).thenReturn(986);
        when(config.getCountries()).thenReturn(country);
        osgiConfig.activate(config);
    }

    @Test
    void getServiceName() {
        OSGiConfigDemoImpl osGiConfigDemo = aemContext.request().adaptTo(OSGiConfigDemoImpl.class);
        assertEquals("UGAM1 Service", osGiConfigDemo.getServiceName());

    }

    @Test
    void getServiceCount() {
        OSGiConfigDemoImpl osGiConfigDemo = aemContext.request().adaptTo(OSGiConfigDemoImpl.class);
        assertEquals(986, osGiConfigDemo.getServiceCount());
    }

    @Test
    void getCountries() {
        OSGiConfigDemoImpl osGiConfigDemo = aemContext.request().adaptTo(OSGiConfigDemoImpl.class);
        assertEquals(country,osGiConfigDemo.getCountries());
    }
}