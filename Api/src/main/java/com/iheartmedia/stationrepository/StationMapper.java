package com.iheartmedia.stationrepository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iheartmedia.model.Station;

@Mapper
public interface StationMapper{
	
	@Update("UPDATE STATIONS SET stationId=#{newStationId}, name=#{newStationName} WHERE name=#{name} AND stationId=#{stationId}")
	void update(@Param("stationId") String stationId, @Param("name") String name, @Param("newStationId") String newStationId, @Param("newStationName") String newStationName);
	
	@Delete("DELETE FROM STATIONS WHERE name=#{name} AND stationId=#{stationId}")
	void delete(Station station);
	
	@Insert("INSERT INTO STATIONS(stationId, name, hdEnabled, callSign) VALUES(#{stationId}, #{name}, #{hdEnabled}, #{callSign})")
	void insert(Station station);
	
	@Select("SELECT * FROM STATIONS")
	List<Station> findAll();

	@Select("SELECT * FROM STATIONS WHERE hdEnabled=true ")
	List<Station> findByHdEnabled(Boolean hdEnabled);

	@Select("SELECT * FROM STATIONS WHERE name=#{name} ")
	List<Station> findByName(String name);

}
