/**
 * 
 */
package com.skeleton.alumini.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.skeleton.alumini.entity.SteelPlant;

/**
 * @author Kamal
 *
 */
public interface ExcelService {
	
	void store(MultipartFile file);
	
	List<SteelPlant> getAllTutorials();

}
