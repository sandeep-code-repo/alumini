/**
 * 
 */
package com.rest.dataservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.entity.FilePath;
import com.rest.dataservice.entity.SteelPlant;
import com.rest.dataservice.util.ResponseObject;

/**
 * @author Kamal
 *
 */
public interface ExcelService {
	
	void store(MultipartFile file);
	
	List<SteelPlant> getAllPlants();
	
	/* ResponseObject saveFileDoc(FilePath filePath,MultipartFile docPath); */

}
