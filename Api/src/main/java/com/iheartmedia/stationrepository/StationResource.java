package com.iheartmedia.stationrepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iheartmedia.model.Station;

@RestController
public class StationResource  {
  
	@Autowired
    private StationMapper stationMapper;
	
	public StationResource(StationMapper stationMapper) {
		this.stationMapper = stationMapper;
	}
	
	@GetMapping("/rest/allStations")
	public List<Station> getAllStations(){
		return stationMapper.findAll();
	}
	
	@RequestMapping(value = "/rest/searchByName", method=RequestMethod.GET)
	public @ResponseBody List<Station> searchStationByName( @ModelAttribute Station station, @RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
		return stationMapper.findByName(station.getName());
	}
	
	@GetMapping("/rest/search/hdEnabled")
	public List<Station> searchStationByHdEnabled(@PathVariable final Boolean hdEnabled){
		return stationMapper.findByHdEnabled(hdEnabled);
	}
}