package com.iheartmedia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.iheartmedia.model.Station;
import com.iheartmedia.stationrepository.StationMapper;

@Controller
@ComponentScan(basePackages = "com.iheartmedia")
@EntityScan(basePackages = "com.iheartmedia")
public class AddStationController {

	@Autowired
	private StationMapper stationMapper;
	
	@RequestMapping(value = "/addstation")
	public String addStation() {
		return "addstation";
	}

	@PostMapping("/addstation")
	public String stationSubmit(@ModelAttribute Station station) {
		if (station == null ) {
			return "addstation";
		}
		
		station.setHdEnabled(false);
		stationMapper.insert(station);
		
        return "addresult";
    }
	
}
