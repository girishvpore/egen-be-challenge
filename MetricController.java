package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.SensorData;
import com.services.MetricService;
@RestController
public class MetricController {
	private MetricService metricService;
	
	@Inject
	public MetricController(MetricService metricService) {
		this.metricService=metricService;
	}
	
	@RequestMapping(value = "metric/read", method = RequestMethod.GET)
    public List<SensorData> readMetric() {
		List<SensorData> datas= new ArrayList<SensorData>();
		datas.add(metricService.readAll());
		metricService.readAll();
		return datas;
        
    }
    @RequestMapping(value="metric/readByTimeRange ",method = RequestMethod.GET)
    public List<SensorData>  readMetricByTimeRange(@RequestParam(value = "fromTime", required = false) String fromTime,
    		@RequestParam(value = "toTime", required = false) String toTime	){
		//call to metric service	
    	
    	return null;
    	
    }
    @RequestMapping(value="metric/create ",method = RequestMethod.POST)
    public String createMetric(@RequestParam(value = "timeStamp", required = true) String timeStamp ,
    		@RequestParam(value = "value", required = true) String value){
    	SensorData data= new SensorData();
    	data.setTimeStamp(timeStamp);
    	data.setValue(Long.valueOf(value));
		return	metricService.createData(data);	
    	
    }
}
