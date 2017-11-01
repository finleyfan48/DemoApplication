package com.iheartmedia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.iheartmedia.model.Station;
import com.iheartmedia.stationrepository.StationMapper;

/**
 * Delete Station Controller
 * @author diontejohnson
 * 
 */
@Controller
@ComponentScan(basePackages = "com.iheartmedia")
@EntityScan(basePackages = "com.iheartmedia")
public class DeleteStationController {
	
	@Autowired
	private StationMapper stationMapper;
	
	@RequestMapping(value = "/deletestation")
	public String index() {
		return "deletestation";
	}

	/**
	 * Return the station once the form is submitted. 
	 *
	 * @param  Station an object 
	 * @return Station from the form submission
	 * @see    String
	 */
	@PostMapping("/deletestation")
	public String stationSubmit(@ModelAttribute Station station) {
		if (station == null ) {
			// error handling goes here
			return "deletestation";
		}
		
		station.setHdEnabled(false);
		stationMapper.delete(station);
        return "deleteresult";
    }
	
}
