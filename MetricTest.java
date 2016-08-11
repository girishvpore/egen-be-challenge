package com.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bean.SensorData;
import com.controller.MetricController;
import com.services.MetricService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MetricTest {

	@Mock
    private MetricService  metricService;
 
    @InjectMocks
    private MetricController metricController;
    
    private SensorData data;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(metricController).build();
 
    }
    
    
    @Test
    public void testcreateData() throws Exception {
     
           
        this.mockMvc.perform(post("metric/create")
                .param("timeStamp", "1470872782020")
                .param("value","150"))
                          .andExpect(status().is4xxClientError());
     
    }
	
}
