/**
 * 
 */
package com.rest.dataservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.entity.SteelPlant;

/**
 * @author Kamal
 *
 */
public interface ExcelService {
	
	void store(MultipartFile file);
	
	List<SteelPlant> getAllPlants();

}
