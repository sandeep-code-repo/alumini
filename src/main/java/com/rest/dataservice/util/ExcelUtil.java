/**
 * 
 */
package com.rest.dataservice.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.SMSReport;
import com.rest.dataservice.entity.StationInfo;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.RealPollutantLevelGraphHelper;
import com.rest.dataservice.helper.UserInfoMapper;
import com.rest.dataservice.model.StationDateLevelGraphRequest;
import com.rest.dataservice.service.ExcelServiceImpl;

/**
 * @author Kamal
 *
 */
public class ExcelUtil {
	private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

	static String[] HEADERs = { "S.No", "Category", "Industry Code", "Industry Name","Full Address", "Contact In which SMSAlerts generated", "State", "Station Name", "Parameter Standard limit's", "Parameters", "Exceedence", "Total SMS","In Ganga Basin"  };
	static String SHEET = "SMSReport";

	static String[] realPollutantTopHEADERs = null;

	static String DATASHEET = "DATA_SHEET";

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	public static boolean hasExcelFormat(MultipartFile file) {
		//check for content type of  excel sheet
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}


	/**
	 * @param is
	 * @return List of Steelplant
	 */
	public static List<UserInfo> parseExcelFile(InputStream is) {
		try {

			XSSFWorkbook workbook = new XSSFWorkbook(is);

			XSSFSheet sheet = workbook.getSheet(workbook.getSheetName(0));
			Iterator<Row> rows = sheet.iterator();

			List<UserInfo> lstUser = new ArrayList<UserInfo>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				if(rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				UserInfo userInfo = new UserInfo();

				int cellIndex = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					if(cellIndex==0) { 
						userInfo.setUserName(currentCell.getStringCellValue());
					} else if(cellIndex==1) { 
						if(currentCell.getCellType() == CellType.STRING) {
							userInfo.setPassword(currentCell.getStringCellValue());
						}else {
							userInfo.setPassword(NumberToTextConverter.toText(currentCell.getNumericCellValue()));
						}
					} else if(cellIndex==2) { 
						userInfo.setAuthPerson(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					} else if(cellIndex==3) { 
						userInfo.setDesignation(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					} else if(cellIndex==4) { 
						if(currentCell.getCellType() == CellType.STRING) {
							userInfo.setMobNo(currentCell.getStringCellValue());
						}else {
							userInfo.setMobNo(NumberToTextConverter.toText(currentCell.getNumericCellValue()));
						}
					}else if(cellIndex==5) { 
						userInfo.setEmail(currentCell.getStringCellValue());
					} else if(cellIndex==6) { 
						userInfo.setSecdPerson(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					} else if(cellIndex==7) { 
						userInfo.setSecdPersonDesig(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					}else if(cellIndex==8) { 
						if(currentCell.getCellType() == CellType.STRING) {
							userInfo.setSecdPersonMob(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
						}else {
							userInfo.setSecdPersonMob(NumberToTextConverter.toText(currentCell.getNumericCellValue()));
						}

					}else if(cellIndex==9) { 
						userInfo.setSecdEmail(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					}else if(cellIndex==10) { 
						userInfo.setStreet(currentCell.getStringCellValue());
					} else if(cellIndex==11) { 
						userInfo.setTown(currentCell.getStringCellValue());
					} else if(cellIndex==12) { 
						userInfo.setDistrict(currentCell.getStringCellValue());
					} else if(cellIndex==13) { 
						userInfo.setState(currentCell.getStringCellValue());
					}else if(cellIndex==14) { 
						if(currentCell.getCellType() == CellType.STRING) {
							userInfo.setPin(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
						}else {
							userInfo.setPin(NumberToTextConverter.toText(currentCell.getNumericCellValue()));
						}
					}

					cellIndex++;
				}

				lstUser.add(userInfo);
			}

			workbook.close();

			return lstUser;
		} catch (IOException e) {
			
			
			logger.error("Error inside method parseExcelFile Info :: "+e.getMessage());
			
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}


	public static ByteArrayInputStream smsReportToExcel(List<SMSReport> smsReports) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			// create style for header cells
			CellStyle style = workbook.createCellStyle(); 
			Font font = workbook.createFont();
			style = workbook.createCellStyle();  
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());  
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setColor(IndexedColors.WHITE.getIndex());
			style.setFont(font);


			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
				cell.setCellStyle(style);
			}

			int rowIdx = 1;
			for (SMSReport smsReport : smsReports) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(smsReport.getId());
				row.createCell(1).setCellValue(smsReport.getIndustryCategory());
				row.createCell(2).setCellValue(smsReport.getIndustryCode());
				row.createCell(3).setCellValue(smsReport.getIndustryName());
				row.createCell(4).setCellValue(smsReport.getAddress());
				row.createCell(5).setCellValue(smsReport.getSmsContactNo());
				row.createCell(6).setCellValue(smsReport.getState());
				row.createCell(7).setCellValue(smsReport.getStationName());
				row.createCell(8).setCellValue(smsReport.getParamLimit());
				row.createCell(9).setCellValue(smsReport.getParameter());
				row.createCell(10).setCellValue(smsReport.getExceedence());
				row.createCell(11).setCellValue(smsReport.getTotalSMS());
				row.createCell(12).setCellValue(smsReport.getInGangaBasinStatus());
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			
			CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			logger.error("Error inside method smsReportToExcel Info :: "+e.getMessage());
			
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}


	public static ByteArrayInputStream realPollutantReportToExcel(
			List<RealPollutantLevelGraphHelper> pollutantGraphList,StationDateLevelGraphRequest graphRequest, StationInfo stationInfo, PlantInfo plantInfo) {
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(DATASHEET);


			// create style for header cells
			CellStyle style = workbook.createCellStyle(); 
			style = workbook.createCellStyle();  
			/*
			 * style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
			 * style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			 */
			Font font = workbook.createFont();
			font.setBold(true);
			font.setFontHeightInPoints((short) 25);
			style.setFont(font);

			CellStyle normalStyle = workbook.createCellStyle();
			normalStyle = workbook.createCellStyle();  
			/*
			 * normalStyle.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
			 * normalStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			 */
			Font normalFont = workbook.createFont();
			normalFont.setBold(true);
			normalFont.setFontHeightInPoints((short) 11);
			normalStyle.setFont(normalFont);

			Date date = Calendar.getInstance().getTime();  
			DateFormat dateFormat = new SimpleDateFormat(ApplicationConstants.DATE_TIME_FORMATTER);  
			String strDate = dateFormat.format(date); 
			String[] realPollutantTopHEADERs= {"Online Pollution Monitoring Portal",plantInfo.getPlantName(),
					"Real Time Report","From Date: "+graphRequest.getFromDate()+"  To Date: "+graphRequest.getToDate(),
					"Report Created by "+graphRequest.getPlantId()+ " on "+strDate};

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < realPollutantTopHEADERs.length; col++) { 

				headerRow = sheet.createRow(col);
				Cell cell =headerRow.createCell(0); 
				cell.setCellValue(realPollutantTopHEADERs[col]);
				if(col==0) {
					cell.setCellStyle(style); 
				}else {
					cell.setCellStyle(normalStyle);
				}


			}


			String[] realPollutantDataHEADERs= new String[2+pollutantGraphList.size()];
			realPollutantDataHEADERs[0]="Sl No";
			realPollutantDataHEADERs[1]="Time";
			int count=2;
			for(int i = 0; i <pollutantGraphList.size(); i++) {
				realPollutantDataHEADERs[count]=stationInfo.getStationId()+"_"+stationInfo.getProcessAttached()+"-"+pollutantGraphList.get(i).getParameter()+"(mg/Nm3)";
				count++;

			}

			Row row = sheet.createRow(6);
			CellStyle style1 = workbook.createCellStyle(); 
			style1.setBorderTop(BorderStyle.THIN);
			style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
			style1.setBorderBottom(BorderStyle.THIN);
			style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			style1.setBorderLeft(BorderStyle.THIN);
			style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			style1.setBorderRight(BorderStyle.THIN);
			style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
			Font font1 = workbook.createFont();
			font1.setBold(true);
			font1.setFontHeightInPoints((short)11);
			style1.setFont(font1);
			for (int col = 0; col < realPollutantDataHEADERs.length; col++) {
				if(col>1) {
					sheet.setColumnWidth(col, 9000);
				}
				Cell cell = row.createCell(col);
				cell.setCellValue(realPollutantDataHEADERs[col]);
				cell.setCellStyle(style1);

			}

			Map<String, List<String>> map = new HashMap<String, List<String>>();
			for(int i=0;i<pollutantGraphList.size();i++) {
				if(i==0) {
					map.put("labels",pollutantGraphList.get(i).getLabels());
				}
				map.put("events"+i,pollutantGraphList.get(i).getEvents());

			}

			int rowIdx = 7;
			for (int j=0;j<map.get("labels").size();j++) {
				Row row1 = sheet.createRow(rowIdx++);
				row1.createCell(0).setCellValue(j+1);
				row1.createCell(1).setCellValue(map.get("labels").get(j));
				row1.createCell(2).setCellValue(map.get("events0").get(j) == null ? "NA" : map.get("events0").get(j));
				for(int i=2;i<map.size();i++) {
					if(map.get("events"+String.valueOf(i-1)).isEmpty()) {
						row1.createCell(i+1).setCellValue("NA");
					}else {
						row1.createCell(i+1).setCellValue(map.get("events"+String.valueOf(i-1)).get(j) == null ? "NA" : map.get("events"+String.valueOf(i-1)).get(j));
					}
				}


			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			
			logger.error("Error inside method realPollutantReportToExcel :: "+e.getMessage());
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

}
