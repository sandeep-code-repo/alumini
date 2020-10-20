
package com.rest.dataservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.entity.FilePath;
import com.rest.dataservice.entity.SteelPlant;
import com.rest.dataservice.service.ExcelService;
import com.rest.dataservice.util.ExcelUtil;
import com.rest.dataservice.util.ResponseMessage;
import com.rest.dataservice.util.ResponseObject;

/**
 * @author Kamal
 *
 */

@RestController
@RequestMapping("/excel")
public class ExcelController {

  private static final String PLEASE_UPLOAD_AN_EXCEL_FILE = "Please upload an excel file!";

private static final String COULD_NOT_UPLOAD_THE_FILE = "Could not upload the file: ";

  private static final String UPLOADED_THE_FILE_SUCCESSFULLY = "Uploaded the file successfully: ";
  
  @Autowired
  ExcelService excelService;
	/*
	 * @Autowired private FileUplaodHelper fileStorage;
	 */
  

  /**
 * @param file
 * @return ResponseEntity
 */
@PostMapping("/savetodb")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (ExcelUtil.hasExcelFormat(file)) {
      try {
        excelService.store(file);

        message = UPLOADED_THE_FILE_SUCCESSFULLY + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
        message = COULD_NOT_UPLOAD_THE_FILE + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      }
    }

    message = PLEASE_UPLOAD_AN_EXCEL_FILE;
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }

  /**
 * @return all tutorials
 */
@GetMapping("/steelplants")
  public ResponseEntity<List<SteelPlant>> getAllPlants() {
    try {
      List<SteelPlant> plants = excelService.getAllPlants();

      if (plants.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(plants, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }



	/*
	 * @PostMapping("/saveDoc") public ResponseEntity<ResponseMessage>
	 * uploadFiledoc(@RequestBody FilePath filePath,@RequestParam("file")
	 * MultipartFile file) { String message = "";
	 * 
	 * if(file!=null) {
	 * 
	 * try { excelService.saveFileDoc(filePath,file);
	 * 
	 * message = UPLOADED_THE_FILE_SUCCESSFULLY + file.getOriginalFilename(); return
	 * ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message)); }
	 * catch (Exception e) { message = COULD_NOT_UPLOAD_THE_FILE +
	 * file.getOriginalFilename() + "!"; return
	 * ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
	 * ResponseMessage(message)); } }
	 * 
	 * 
	 * message = PLEASE_UPLOAD_AN_EXCEL_FILE; return
	 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
	 * ResponseMessage(message)); }
	 */
}