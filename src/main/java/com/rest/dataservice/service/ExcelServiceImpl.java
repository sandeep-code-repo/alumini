
package com.rest.dataservice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.entity.SteelPlant;
import com.rest.dataservice.repository.SteelPlantRepository;
import com.rest.dataservice.util.ExcelUtil;

/**
 * @author Kamal
 *
 */
@Service
public class ExcelServiceImpl  implements ExcelService {
	
	  @Autowired
	  SteelPlantRepository repository;

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

}
