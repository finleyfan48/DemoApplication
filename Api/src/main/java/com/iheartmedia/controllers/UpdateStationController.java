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
public class UpdateStationController {
	
	@Autowired
	private StationMapper stationMapper;
	
	@RequestMapping(value = "/updatestation")
	public String index() {
		return "updatestation";
	}

	/**
	 * Return the station once the form is submitted. 
	 *
	 * @param  Station an object 
	 * @return Station from the form submission
	 * @see    String
	 */
	@RequestMapping(value = "/updatestation", method = RequestMethod.POST)
	public String stationSubmit(@ModelAttribute Station station, @RequestParam("newStationId") String newStationId, @RequestParam("newStationName") String newStationName) {
		if (station == null ) {
			return "updatestation";
		}
		
		stationMapper.update(station.getStationId(), station.getName(), newStationId, newStationName);
		
        return "updateresult";
    }
	
}
