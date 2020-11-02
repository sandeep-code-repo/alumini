/**
 * 
 */
package com.rest.dataservice.util;

import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.UserInfoMapper;

/**
 * @author Kamal
 *
 */
public class ExcelUtil {

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
						userInfo.setPassword(currentCell.getStringCellValue());
					} else if(cellIndex==2) { 
						userInfo.setDepartment(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					} else if(cellIndex==3) { 
						userInfo.setUserType(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					}else if(cellIndex==4) { 
						userInfo.setReportto(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					} else if(cellIndex==5) { 
						userInfo.setAuthPerson(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					} else if(cellIndex==6) { 
						userInfo.setDesignation(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					} else if(cellIndex==7) { 
						userInfo.setMobNo(NumberToTextConverter.toText(currentCell.getNumericCellValue()));
					}else if(cellIndex==8) { 
						userInfo.setEmail(currentCell.getStringCellValue());
					} else if(cellIndex==9) { 
						userInfo.setSecdPerson(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					} else if(cellIndex==10) { 
						userInfo.setSecdPersonDesig(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					}else if(cellIndex==11) { 
						if(currentCell.getCellType() == CellType.STRING) {
							userInfo.setSecdPersonMob(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":NumberToTextConverter.toText(currentCell.getNumericCellValue()));
						}else {
							userInfo.setSecdPersonMob(NumberToTextConverter.toText(currentCell.getNumericCellValue()));
						}
						
					}else if(cellIndex==12) { 
						userInfo.setSecdEmail(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":currentCell.getStringCellValue());
					}else if(cellIndex==13) { 
						userInfo.setStreet(currentCell.getStringCellValue());
					} else if(cellIndex==14) { 
						userInfo.setTown(currentCell.getStringCellValue());
					} else if(cellIndex==15) { 
						userInfo.setDistrict(currentCell.getStringCellValue());
					} else if(cellIndex==16) { 
						userInfo.setState(currentCell.getStringCellValue());
					}else if(cellIndex==17) { 
						if(currentCell.getCellType() == CellType.STRING) {
							userInfo.setPin(currentCell.getStringCellValue().equalsIgnoreCase("NA")?"":NumberToTextConverter.toText(currentCell.getNumericCellValue()));
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

}
