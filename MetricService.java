package com.services;

import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Service;

import com.bean.SensorData;
import com.dao.MongoDatastore;
import com.entity.MetricEntity;

@Service
public class MetricService {

	public String createData( SensorData data){
		Datastore datastore= MongoDatastore.getInstance();
		MetricEntity metricEntity= new MetricEntity();
		metricEntity.setTimeStamp(data.getTimeStamp());
		metricEntity.setValue(data.getValue());
		
		datastore.save(metricEntity);
		return "sucsess";
	}
	
	public SensorData readAll(){
		Datastore datastore= MongoDatastore.getInstance();
		MetricEntity entity= datastore.find(MetricEntity.class).get();
		SensorData data= new SensorData();
		data.setTimeStamp(entity.getTimeStamp());
		data.setValue(entity.getValue());
		return data;
	}
}
