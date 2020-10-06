/**
 * 
 */
package com.skeleton.alumini.util;

import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import com.skeleton.alumini.entity.SteelPlant;

/**
 * @author Kamal
 *
 */
public class ExcelUtil {
	
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<SteelPlant> parseExcelFile(InputStream is) {
			try {
	    		XSSFWorkbook workbook = new XSSFWorkbook(is);
	     
	    		XSSFSheet sheet = workbook.getSheet(workbook.getSheetName(0));
	    		Iterator<Row> rows = sheet.iterator();
	    		
	    		List<SteelPlant> lstPlants = new ArrayList<SteelPlant>();
	    		
	    		int rowNumber = 0;
	    		while (rows.hasNext()) {
	    			Row currentRow = rows.next();
	    			
	    			if(rowNumber == 0) {
	    				rowNumber++;
	    				continue;
	    			}
	    			
	    			Iterator<Cell> cellsInRow = currentRow.iterator();

	    			SteelPlant plant = new SteelPlant();
	    			
	    			int cellIndex = 0;
	    			while (cellsInRow.hasNext()) {
	    				Cell currentCell = cellsInRow.next();
	    				
	    				if(cellIndex==0) { 
	    					plant.setPlantId((int) currentCell.getNumericCellValue());
	    				} else if(cellIndex==1) { 
	    					plant.setPlantName(currentCell.getStringCellValue());
	    				} else if(cellIndex==2) { 
	    					plant.setPlantAddress(currentCell.getStringCellValue());
	    				} else if(cellIndex==3) { 
	    					plant.setPlantStatus(currentCell.getStringCellValue());
	    				}
	    				
	    				cellIndex++;
	    			}
	    			
	    			lstPlants.add(plant);
	    		}
	    		
	    		workbook.close();
	    		
	    		return lstPlants;
	        } catch (IOException e) {
	        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
	        }
		}

}
