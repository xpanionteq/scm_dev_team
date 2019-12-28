package com.xpanion.scm.excellistview;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import com.xpanion.scm.model.ReportModel;

public class ItemTypeReport {

	@SuppressWarnings("deprecation")
	public static ByteArrayInputStream buildExcelDocument(List<ReportModel> apachepoiModel) {
	try {
		    XSSFWorkbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			XSSFSheet  sheet = workbook.createSheet(" Item Type Report");
			CreationHelper createHelper = workbook.getCreationHelper();   
			XSSFCellStyle stylealign = workbook.createCellStyle();
		    stylealign.setAlignment(HorizontalAlignment.LEFT);
		           
		    XSSFCellStyle styleone = workbook.createCellStyle(); 
			XSSFFont my_font=workbook.createFont();
			my_font.setBold(true);
			my_font.setColor(IndexedColors.WHITE.getIndex());
			styleone.setFont(my_font); 
			styleone.setAlignment(HorizontalAlignment.CENTER);
			styleone.setVerticalAlignment(VerticalAlignment.CENTER);
			styleone.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());  
			styleone.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			  
		    XSSFCellStyle style = workbook.createCellStyle();
		    XSSFFont my_fonts=workbook.createFont();
		    my_fonts.setBold(true);
		    my_fonts.setColor(IndexedColors.BROWN.getIndex());
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setWrapText(true);
			style.setFont(my_fonts);
		    style.setVerticalAlignment(VerticalAlignment.CENTER);
		    
		    XSSFCellStyle stylecolor = workbook.createCellStyle();
		    XSSFFont my_fontone=workbook.createFont();
		    my_fontone.setBold(true);
		    my_fontone.setColor(IndexedColors.BLACK.getIndex());
		    stylecolor.setFont(my_fontone);
		    stylecolor.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());  
		    stylecolor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		      
		      
	      XSSFCellStyle styles = workbook.createCellStyle();
	      XSSFFont my_fonttwo=workbook.createFont();
	      my_fonttwo.setBold(true);
	      my_fonttwo.setColor(IndexedColors.BLACK.getIndex());
	      styles.setFont(my_fonttwo); 
		  styles.setAlignment(HorizontalAlignment.CENTER);
	      
		  styles.setVerticalAlignment(VerticalAlignment.CENTER);
	      styles.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());  
	      styles.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	      
	      
	      XSSFFont fontone=workbook.createFont();
	      fontone.setBold(true);
	      fontone.setColor(IndexedColors.BLACK.getIndex());
	      
	      XSSFCellStyle stylealignr = workbook.createCellStyle();
	      XSSFFont fontwo=workbook.createFont();
	      fontwo.setBold(true);
	      stylealignr.setFont(fontwo);
	      stylealignr.setAlignment(HorizontalAlignment.RIGHT);
	      stylealignr.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());  
	      stylealignr.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	      
	      XSSFCellStyle style3 = workbook.createCellStyle(); 
	      XSSFFont my_font3=workbook.createFont();
	      my_font3.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	      my_font3.setColor(IndexedColors.BLACK.getIndex());
	      style3.setFont(my_font3);
		  
	      Integer rowNumber;
		  rowNumber= 0;
		 
		  XSSFRow headdata = sheet.createRow(rowNumber+2);
		  XSSFCell cell = (XSSFCell) headdata.createCell(2);
		  
		  sheet.addMergedRegion(new CellRangeAddress(2,7,2,10));
		  for(ReportModel user : apachepoiModel ) {
				 
			 cell.setCellValue(user.getItemName()+","+"\r\n"+user.getItemId()+","+"\r\n"+user.getMrp());
			 cell.setCellStyle(style);
		  }
		  
		 
		  for(ReportModel user : apachepoiModel ) {
			  if(user.getItemLogo().isEmpty()) {
                  System.out.println("No Logo");
                     
          }else {
          
		  InputStream inputStream = ReportModel.class.getResourceAsStream(user.getItemLogo());
	
		   byte[] imageBytes = IOUtils.toByteArray(inputStream);
	
		   int pictureureIdx = workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);
	
		   inputStream.close();
	
		   CreationHelper helper = workbook.getCreationHelper();
	
		   Drawing drawing = sheet.createDrawingPatriarch();
	
		   ClientAnchor anchor = helper.createClientAnchor();
	
		  
		   anchor.setCol1(1);
		   anchor.setCol2(2);
		   anchor.setRow1(2);
		   anchor.setRow2(4);
	      Picture pict= drawing.createPicture(anchor, pictureureIdx);
	      pict.resize(1,2);
		  }	  	  
		  }
		  headdata = sheet.createRow(rowNumber+8);
		  headdata.createCell(2).setCellValue("Item Id");
		  sheet.autoSizeColumn(2);
		  sheet.addMergedRegion(new CellRangeAddress(8,8,3,10));
		  for(ReportModel user : apachepoiModel ) {
				 
			  XSSFCell cellli = (XSSFCell) headdata.createCell(3); 
			  cellli.setCellValue(user.getItemId());
			  cellli.setCellStyle(style3);
		  }
		  
		  headdata = sheet.createRow(rowNumber+9);
		  headdata.createCell(2).setCellValue("Item Name ");
		  sheet.autoSizeColumn(2);
		  sheet.addMergedRegion(new CellRangeAddress(9,9,3,10));
		  for(ReportModel user : apachepoiModel ) {
				 
			  XSSFCell celllic = (XSSFCell) headdata.createCell(3); 
			  celllic.setCellValue(user.getItemName());
			  celllic.setCellStyle(style3);
		  } 
		 
	      headdata = sheet.createRow(rowNumber+11);
	      XSSFCell celllr = (XSSFCell) headdata.createCell(1);
	      sheet.addMergedRegion(new CellRangeAddress(11,11,1,10)); 
	      celllr.setCellValue("Transaction Report ");
	      celllr.setCellStyle(styleone);
		  
	      headdata = sheet.createRow(rowNumber+13);
	      XSSFCell celllfrom = (XSSFCell) headdata.createCell(2);
	      celllfrom.setCellValue("From ");
	      for(ReportModel user : apachepoiModel ) {
	    	  XSSFCell celllfromdate = (XSSFCell) headdata.createCell(3);
	    	  celllfromdate.setCellValue(user.getFromDate());
	    	  celllfromdate.setCellStyle(style3);
	      }
	      XSSFCell celltodaydate = (XSSFCell) headdata.createCell(8);
	      celltodaydate.setCellValue("Date");
	      XSSFCellStyle cellStyle = workbook.createCellStyle();  
	  	  cellStyle.setAlignment(HorizontalAlignment.LEFT);
	  	  XSSFFont my_font4=workbook.createFont();
		  my_font4.setBold(true);
		  cellStyle.setFont(my_font4);
	      cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("mm/dd/yyyy"));
	      XSSFCell datecell=headdata.createCell(9);
	      datecell = headdata.createCell(9);  
	      datecell.setCellValue(new Date());  
	      datecell.setCellStyle(cellStyle);
	      
	      headdata = sheet.createRow(rowNumber+14);
	      XSSFCell cellto = (XSSFCell) headdata.createCell(2);
	      cellto.setCellValue("To");
	      
	   	  for(ReportModel user : apachepoiModel ) {
	   		  XSSFCell celltodate = (XSSFCell) headdata.createCell(3);
	   		  celltodate.setCellValue(user.getToDate());
	   		  celltodate.setCellStyle(style3);
	         }   
	   	  XSSFCell cellfuel = (XSSFCell) headdata.createCell(8);
	      cellfuel.setCellValue("Item Type Report      ");
	      sheet.addMergedRegion(new CellRangeAddress(14,14,9,10));
		  for(ReportModel user : apachepoiModel ) {
			  XSSFCell cellfueltype = (XSSFCell) headdata.createCell(9);
			  cellfueltype.setCellValue(user.getItemType());
			  cellfueltype.setCellStyle(style3);
		  }
		 
		 
		   XSSFCellStyle styletwo = workbook.createCellStyle();
		    styletwo.setBorderBottom(BorderStyle.THIN);
		    styletwo.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		    styletwo.setBorderLeft(BorderStyle.THIN);
		    styletwo.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		    styletwo.setBorderRight(BorderStyle.THIN);
		    styletwo.setRightBorderColor(IndexedColors.BLACK.getIndex());
		    styletwo.setBorderTop(BorderStyle.THIN);
			styletwo.setTopBorderColor(IndexedColors.BLACK.getIndex());
		    
		  
			 headdata = sheet.createRow(rowNumber+16);
			 XSSFCell cellone = headdata.createCell( 1 ); 
			 cellone .setCellValue("S.No.             ");
			 sheet.autoSizeColumn(1);
		 	 cellone.setCellStyle(styleone);
		 	 XSSFCell celldate = headdata.createCell( 2 );  
		 	 celldate.setCellValue("Date           ");
		 	 sheet.autoSizeColumn(2);
		 	 celldate.setCellStyle(styleone);
		 	 XSSFCell cellid = headdata.createCell( 3 );
		 	 cellid .setCellValue("Item ID");
			 sheet.autoSizeColumn(3);
		 	 cellid .setCellStyle(styleone);
		 
			XSSFCell cellname = headdata.createCell( 4);
			cellname.setCellValue("Item Name");
			sheet.autoSizeColumn(4);
			cellname.setCellStyle(styleone);
			XSSFCell cellve = headdata.createCell( 5 );
			cellve.setCellValue("Mrp");
			sheet.autoSizeColumn(5);
			cellve.setCellStyle(styleone);
			
			XSSFCell cellcon = headdata.createCell( 6 );
			cellcon.setCellValue("Stock");
			sheet.autoSizeColumn(6);
			cellcon.setCellStyle(styleone);
			
			XSSFCell cellbilln = headdata.createCell( 7);
			cellbilln.setCellValue("Threshold Stock");
			sheet.autoSizeColumn(7);
			cellbilln.setCellStyle(styleone);
			XSSFCell cellpri = headdata.createCell( 8);
			cellpri.setCellValue("Manufacturer");
			sheet.autoSizeColumn(8);
			cellpri.setCellStyle(styleone);
		    Integer rowNum ;
		    rowNum= 17;   
		    Integer s_no=0;
		    for(ReportModel user : apachepoiModel ) {
		       XSSFRow row = sheet.createRow(rowNum++);
			   XSSFSheet sheet2= workbook.getSheetAt(0);
			   s_no = s_no+1;
			   XSSFCell cellsno = row.createCell( 1);
			   cellsno.setCellValue(s_no);
			   cellsno.setCellStyle(styletwo);
	  		   XSSFCell celltd= row.createCell( 2);
	  		   celltd.setCellValue(user.getFromDate());
	  		   celltd.setCellStyle(styletwo);
			   XSSFCell cellcusid = row.createCell( 3 );
			   cellcusid.setCellValue(user.getItemId());
			   cellcusid.setCellStyle(styletwo);
			   XSSFCell cellcusname = row.createCell( 4 );
			   cellcusname.setCellValue(user.getItemName());
			   cellcusname.setCellStyle(styletwo);
			  
			 }	   
			  
		  
		    XSSFSheet sheet1 = workbook.getSheetAt(0);
		    int v_no=sheet1.getLastRowNum();
			headdata = sheet.createRow(v_no+1);
		    XSSFCell celltot = headdata.createCell(8);
		    celltot.setCellValue("Total(₹)");
		    celltot.setCellStyle(stylecolor);
		   /* for(ReportModel user : ReportModel ) {
			  XSSFCell celllitretot = headdata.createCell( 9 );	 
			  celllitretot.setCellValue(user.getLitre_sum());
			  celllitretot.setCellStyle(stylealignr);
			  XSSFCell celltota = headdata.createCell( 10 );	 
			  celltota.setCellValue(user.getTotal());
			  celltota.setCellStyle(stylealignr);
		     }*/
		  
			 
		  headdata = sheet.createRow(v_no+5);
		  XSSFCell cellend = headdata.createCell( 1);
		  cellend.setCellValue("End of the Report");
		  cellend.setCellStyle(styles);
		  sheet.addMergedRegion(new CellRangeAddress(v_no+5,v_no+5,1,10));
		       
		  workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
		 } catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
		
	}
}
//--------------------------------------------------END-------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
