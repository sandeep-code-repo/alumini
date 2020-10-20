
package com.rest.dataservice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.FilePath;
import com.rest.dataservice.entity.FilePath;
import com.rest.dataservice.entity.SteelPlant;
import com.rest.dataservice.repository.FileRepository;
import com.rest.dataservice.repository.SteelPlantRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ExcelUtil;
import com.rest.dataservice.util.ResponseObject;

/**
 * @author Kamal
 *
 */
@Service
public class ExcelServiceImpl  implements ExcelService {
	
	  @Autowired
	  SteelPlantRepository repository;
	  
	/*
	 * @Autowired private FileUplaodHelper fileStorage;
	 */
	  
	  @Autowired
	  FileRepository fileRepository;

	  public void store(MultipartFile file) {
	    try {
	      List<SteelPlant> plants = ExcelUtil.parseExcelFile(file.getInputStream());
	      repository.saveAll(plants);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<SteelPlant> getAllPlants() {
	    return repository.findAll();
	  }

	/*
	 * @Override public ResponseObject saveFileDoc(FilePath filePath, MultipartFile
	 * docPath) {
	 * 
	 * String file="";
	 * 
	 * try {
	 * 
	 * file = fileStorage.saveUploadedFile(docPath); filePath.setDocPath(file);
	 * fileRepository.save(filePath);
	 * 
	 * 
	 * } catch (IOException ex) {
	 * 
	 * ex.printStackTrace(); }
	 * 
	 * CommonApiStatus SuccessApiStatus = new
	 * CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
	 * HttpStatus.CREATED, ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS); return
	 * new ResponseObject("File Path saved Successfully", SuccessApiStatus); }
	 */

}
