package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.SensorData;
import com.services.AlertService;
@RestController
public class AlertController {
	
	private AlertService alertService;
	
	@Inject
	public AlertController(AlertService alertService) {
		this.alertService=alertService;
	}
	
	@RequestMapping(value = "alert/read", method = RequestMethod.GET)
    public List<SensorData> readMetric() {
		List<SensorData> sensorDatas= new ArrayList<SensorData>();
		//call to alertservice
		return sensorDatas;
        
    }
    @RequestMapping(value="alert/readByTimeRange ",method = RequestMethod.GET)
    public List<SensorData>  readMetricByTimeRange(@RequestParam(value = "fromTime", required = false) String fromTime,
    		@RequestParam(value = "toTime", required = false) String toTime	){
    	List<SensorData> sensorDatas= new ArrayList<SensorData>();
    	//call to alertservice
				return sensorDatas;
    	
    }
    
}
