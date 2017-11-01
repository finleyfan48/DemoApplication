package com.iheartmedia.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.iheartmedia.model.Station;
import com.iheartmedia.stationrepository.StationMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings("unused")
public class DeleteStationTests {
	
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
	public void tearDown() throws Exception { }
	
	@Test
	public void testSubmitDeleteStation() {
	
	}

}
