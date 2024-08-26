package com.main.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rail {

	@Id
	private String railId;
	private String railName;
	private long pnr;
	private String departureStationName;
	private String arrivalStationName;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp startTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp endTime;
	
}
