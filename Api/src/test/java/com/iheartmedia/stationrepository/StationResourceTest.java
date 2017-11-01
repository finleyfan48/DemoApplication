package com.iheartmedia.stationrepository;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.iheartmedia.controllers.AddStationController;
import com.iheartmedia.model.Station;

@SuppressWarnings("unused")
public class StationResourceTest {

	private MockMvc mockMvc;
	private Station station;
	
	@Autowired
	private StationMapper stationMapper;
	
	@Mock
	private AddStationController addStation;
		
	@Before
	public void setUp() throws Exception {
		station = new Station("106.1", "Kiss", false, "FM");
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(addStation).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllStations() {

	}
	
	@Test
	public void testStationBtName() {
		
	}
	
	@Test
	public void testSearchStationByHdEnabled() {
		
	}

}
