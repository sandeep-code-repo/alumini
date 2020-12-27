package com.rest.dataservice.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.rest.dataservice.entity.SMSReport;


public class ReportPDFExporter {
	
	static String[] HEADERs = { "S.No", "Category", "Industry Code", "Industry Name","Full Address", "Contact In which SMSAlerts generated", "State", "Station Name", "Parameter Standard limit's", "Parameters", "Exceedence", "Total SMS","In Ganga Basin"  };
	  static String SHEET = "SMSReport";
	
	 private List<SMSReport> listSMSReport;
     
	    public ReportPDFExporter(List<SMSReport> listSMSReport) {
	        this.listSMSReport = listSMSReport;
	    }
	 
	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        for (int col = 0; col < HEADERs.length; col++) {
	            cell.setPhrase(new Phrase(HEADERs[col], font));
		        table.addCell(cell);
	          }
	    }
	     
	    private void writeTableData(PdfPTable table) {
	        for (SMSReport smsReport : listSMSReport) {
	            table.addCell(String.valueOf(smsReport.getId()));
	            table.addCell(smsReport.getIndustryCategory());
	            table.addCell(smsReport.getIndustryCode());
	            table.addCell(smsReport.getIndustryName());
	            table.addCell(smsReport.getAddress());
	            table.addCell(smsReport.getSmsContactNo());
	            table.addCell(smsReport.getState());
	            table.addCell(smsReport.getStationName());
	            table.addCell(smsReport.getParamLimit());
	            table.addCell(smsReport.getParameter());
	            table.addCell(smsReport.getExceedence());
	            table.addCell(smsReport.getTotalSMS());
	            table.addCell(smsReport.getInGangaBasinStatus());
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("SMS Reports", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(13);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f,1.5f, 3.5f, 3.0f, 3.0f, 1.5f,3.0f, 3.0f, 1.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
	
	
}
