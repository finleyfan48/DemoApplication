package com.iheartmedia;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iheartmedia.model.Station;

@MappedTypes(Station.class)
@MapperScan("com.iheartmedia.stationrepository")
@SpringBootApplication
public class ApiApplication{

	public static void main(String [] args) throws Exception{
		SpringApplication.run(ApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("CommandLineRunner running in the UnsplashApplication class...");
		};
	}
}
