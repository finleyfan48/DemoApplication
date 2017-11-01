package com.iheartmedia.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.iheartmedia.model.Station;
import com.iheartmedia.stationrepository.StationMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings("unused")
public class AddStationTests {

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
	public void testStationSubmit() {
		String json = "'[{\\\"stationId\\\":\\\"104.5\\\",\\\"name\\\":\\\"K104\\\",\\\"hdEnabled\\\":true,\\\"callSign\\\":\\\"FM\\\"},{\\\"stationId\\\":\\\"100.3\\\",\\\"name\\\":\\\"KTJ\\\",\\\"hdEnabled\\\":false,\\\"callSign\\\":\\\"FM\\\"},{\\\"stationId\\\":\\\"106.2\\\",\\\"name\\\":\\\"Kisses\\\",\\\"hdEnabled\\\":true,\\\"callSign\\\":\\\"FM\\\"}]\'";
		
	    // convert to json string
	    try {
			mockMvc.perform(MockMvcRequestBuilders.post("/addstation")
			        .contentType(MediaType.APPLICATION_JSON)
			        .content(json)
			        .accept(MediaType.APPLICATION_JSON))
			        .andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testAddStation() {
		
	}

}
