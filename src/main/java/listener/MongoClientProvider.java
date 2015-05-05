/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import com.mongodb.MongoClient;
import javax.ejb.Startup;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class MongoClientProvider {
		
	private MongoClient mongoClient = null;
		
	@Lock(LockType.READ)
	public MongoClient getMongoClient(){	
		return mongoClient;
	}
	
	@PostConstruct
	public void init() {
		String mongoIpAddress = "localhost";
		Integer mongoPort = 27017;
		try {
			mongoClient = new MongoClient(mongoIpAddress, mongoPort);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		
}