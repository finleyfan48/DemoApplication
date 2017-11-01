/**
 * 
 */
package com.iheartmedia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author diontejohnson
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Station {
	
	@Id @GeneratedValue
	private String stationId;
	private String name;
	private Boolean hdEnabled;
	private String callSign;
	
}
