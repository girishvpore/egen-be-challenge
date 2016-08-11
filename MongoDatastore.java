package com.dao;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MongoDatastore {

	private static  Datastore datastore;
	public static Datastore getInstance()
	{
		if (datastore!=null){
		MongoClient mongo;
		try {
			mongo = new MongoClient("localhost", 27017);

			Morphia morphia = new Morphia();
			datastore = morphia.createDatastore(mongo, "myMongodb");
			morphia.mapPackage("com.entity");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		}
		
		return datastore;
	}
	
}
