package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Rail;
import com.main.service.RailService;

@RestController
@RequestMapping("/rail-service")
public class RailController {

	@Autowired
	private RailService railService;

	@PostMapping("/saveAll")
	public ResponseEntity<List<Rail>> saveAllRail(@RequestBody List<Rail> rails) {
		List<Rail> railSaved = this.railService.saveListOfRail(rails);
		return ResponseEntity.ok(railSaved);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Rail> saveRail(@RequestBody Rail rail) {
		Rail railSaved = this.railService.saveRail(rail);
		return ResponseEntity.ok(railSaved);
	}
	
	@GetMapping("/{railId}")
	public ResponseEntity<Rail> getById(@PathVariable String railId) {
		return ResponseEntity.ok(this.railService.getRailById(railId));
	}
	
	@GetMapping("/getAllRail")
	public ResponseEntity<List<Rail>> getAllRail() {
		return ResponseEntity.ok(this.railService.getAllRail());
	}
	
	@PutMapping("/modifiedRail")
	public ResponseEntity<Rail> modifiedRail(@RequestBody Rail rail) {
		return ResponseEntity.ok(this.railService.modifiedRailById(rail));
	}
	
	@DeleteMapping("/deleteRail/{railId}")
	public void deleteRail(@PathVariable String railId) {
		 this.railService.deletedRailById(railId);
	}
}
