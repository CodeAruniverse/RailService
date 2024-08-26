package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Rail;
import com.main.exception.ResourceNotFoundException;
import com.main.repo.RailRepo;

@Service
public class RailServiceImpl implements RailService {
	
	@Autowired
	private RailRepo railRepo;

	@Override
	public Rail saveRail(Rail rail) {
		String railUUID = UUID.randomUUID().toString();
		rail.setRailId(railUUID);
		return this.railRepo.save(rail);
	}

	@Override
	public List<Rail> saveListOfRail(List<Rail> rails) {
		List<Rail> savedRails = new ArrayList<>();
		for(Rail rail : rails) {
			String randomUUID = UUID.randomUUID().toString();
			rail.setRailId(randomUUID);
		}
		savedRails = this.railRepo.saveAll(rails);
		return savedRails;
	}

	@Override
	public List<Rail> getAllRail() {
		return this.railRepo.findAll();
	}

	@Override
	public Rail getRailById(String railId) {
		return this.railRepo.findById(railId).orElseThrow( () -> new ResourceNotFoundException("Specified rail is not found"));
	}

	public Rail modifiedRailById(Rail rail) {
		Rail insertRail = null;
		// find the rail using rail id if present or not
		String railId = rail.getRailId();
		Optional<Rail> byId = this.railRepo.findById(railId);
		if(byId != null) {
			insertRail = this.railRepo.save(rail);
		}else {
			System.out.println("Specified Rail is not present to modify");
		}
		// if present replace the rail using save
		return insertRail;
	}

	@Override
	public void deletedRailById(String railId) {
		Optional<Rail> deleteId = this.railRepo.findById(railId);
		if(deleteId != null) {
			this.railRepo.deleteById(railId);
		}
		else {
			System.out.println("Specified Rail is not present");
		}
	}

}
