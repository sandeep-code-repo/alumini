package com.rest.dataservice.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.entity.Industry;
import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.entity.SMSReport;
import com.rest.dataservice.model.StationDateLevelGraphRequest;
import com.rest.dataservice.repository.SMSReportRepository;
import com.rest.dataservice.service.IndustryCategoryService;
import com.rest.dataservice.util.AbstractMapper;
import com.rest.dataservice.util.ReportPDFExporter;
import com.rest.dataservice.util.RequestObject;
import com.rest.dataservice.util.ResponseObject;

@RestController
@RequestMapping("/industry")
public class IndustryCategoryController extends AbstractMapper{

	private static final Logger logger = LogManager.getLogger(IndustryCategoryController.class);

	@Autowired
	IndustryCategoryService industryCategoryService;
	
	@Autowired
	SMSReportRepository smsReportRepository;


	/**
	 * @return ResponseObject
	 */
	@PostMapping
	public ResponseObject addIndustryDetails(@RequestBody IndustryCategory industryCatagory) {
		//IndustryCatagory industry = (IndustryCatagory) getParsedObject(industryCatagory.getName(), IndustryCatagory.class);
		return industryCategoryService.addIndustryDetails(industryCatagory);
	}


	@GetMapping(value ="/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObject getindustrydtlsByCategory(@PathVariable("category")String category) {

		return industryCategoryService.getIndustryDetailsByCategory(category); 

	}

	/**
	 * @return ResponseObject
	 * Return all Category
	 */
	@GetMapping
	public ResponseObject getIndustryList() {
		return industryCategoryService.getIndustryList();
	}



	/**
	 * Category Edit By Name
	 */

	@PutMapping(value ="/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject editCategoryData(@PathVariable("name") String name) {

		return industryCategoryService.editByEname(name);

	}

	@GetMapping(value ="/dropdownIndustryList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject getDropdownIndustryCategoryList() {
		ResponseObject obj= industryCategoryService.getDropdownIndustryCategoryList();
		return obj;
	}


	@GetMapping(value ="/getSMSReport", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject getSMSReport() {
		ResponseObject obj= industryCategoryService.getSMSReport();
		return obj;
	}

	@GetMapping("/getSMSReport/download")
	public ResponseEntity<Resource> getFile(@RequestParam String from,@RequestParam String to) throws ParseException {
		String filename = "smsReport.xlsx";

		InputStreamResource file = new InputStreamResource(industryCategoryService.getSMSReportInExcel(from,to));

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}

	@GetMapping("/getSMSReport/downloadpdf")
    public void exportToPDF(HttpServletResponse response,@RequestParam String from,@RequestParam String to) throws DocumentException, IOException, ParseException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=sms_report_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        List<SMSReport> smsReport = smsReportRepository.getReportInRange(sdf.parse(from),sdf.parse(to));
         
        ReportPDFExporter exporter = new ReportPDFExporter(smsReport);
        exporter.export(response);
         
    }

}
