package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{

	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
	
	File src=new File("./TestData/Data.xlsx");
	 
	 try {
		 
		FileInputStream fis=new FileInputStream(src);
		 
	   wb=new XSSFWorkbook(fis);
	
	 
	 } catch (Exception e) {
		 
	   System.out.println("Unable to read the Excel File" +e.getMessage());	 
		
	     } 
		
	}	
		
	
	  public String getStringData(int SheetIndex, int row, int coloumn)
     
     {
     return wb.getSheetAt(SheetIndex).getRow(row).getCell(coloumn).getStringCellValue();
     }
	
	
	  public String getStringData(String SheetName, int row, int coloumn)
     
      {
      return wb.getSheet(SheetName).getRow(row).getCell(coloumn).getStringCellValue(); 
      }
     
     
      public double getNumericData(String SheetName, int row, int coloumn)
      {
      return wb.getSheet(SheetName).getRow(row).getCell(coloumn).getNumericCellValue(); 
      }
     
}
     
     
     
   
   


	
	
		
		
	


