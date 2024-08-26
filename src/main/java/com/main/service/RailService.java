package com.main.service;

import java.util.List;
import com.main.entity.Rail;

public interface RailService {

	//1. Create a Rail Service
	Rail saveRail(Rail rail);
	
	//2. Create a list of rail at one time
	List<Rail> saveListOfRail(List<Rail> rails);
	
	//3. Get All Rail Service
	List<Rail> getAllRail();
	
	//4. Get a Rail detail by railId
	Rail getRailById(String railId);
	
	//5. modify the rail by railId
	Rail modifiedRailById(Rail rail);
	
	//6. delete the rail by id
	void deletedRailById(String railId);
	
}
