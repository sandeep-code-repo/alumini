
package com.skeleton.alumini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skeleton.alumini.service.ExcelService;
import com.skeleton.alumini.entity.SteelPlant;
import com.skeleton.alumini.util.ExcelUtil;
import com.skeleton.alumini.util.ResponseMessage;

/**
 * @author Kamal
 *
 */

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

  @Autowired
  ExcelService excelService;

  @PostMapping("/savetodb")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (ExcelUtil.hasExcelFormat(file)) {
      try {
        excelService.store(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      }
    }

    message = "Please upload an excel file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }

  @GetMapping("/steelplants")
  public ResponseEntity<List<SteelPlant>> getAllTutorials() {
    try {
      List<SteelPlant> tutorials = excelService.getAllTutorials();

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}