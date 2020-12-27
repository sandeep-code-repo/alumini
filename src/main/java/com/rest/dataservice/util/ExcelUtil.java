/**
 * 
 */
package com.rest.dataservice.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.entity.SMSReport;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.UserInfoMapper;

/**
 * @author Kamal
 *
 */
public class ExcelUtil {
	
	  static String[] HEADERs = { "S.No", "Category", "Industry Code", "Industry Name","Full Address", "Contact In which SMSAlerts generated", "State", "Station Name", "Parameter Standard limit's", "Parameters", "Exceedence", "Total SMS","In Ganga Basin"  };
	  static String SHEET = "SMSReport";

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
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}


    public static ByteArrayInputStream tutorialsToExcel(List<SMSReport> smsReports) {

    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
      Sheet sheet = workbook.createSheet(SHEET);

      // Header
      Row headerRow = sheet.createRow(0);

      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
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
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }

}
