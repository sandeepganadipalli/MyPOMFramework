package com.qa.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	//static Workbook workbook;
	//static HSSFSheet  sheet;
	//static HSSFWorkbook workbook;
	static XSSFWorkbook workbook;
	static XSSFSheet  sheet;
	
	public static String TESTDATA_SHEET_PATH ="C:\\Users\\sande\\eclipse-workspace\\MavenHybridApproach"
			+ "\\src\\main\\java\\com\\qa\\crm\\testdata\\CrmTestData.xlsx";

	
	/**
	 * This method is used to get test data from test data sheet on the basis of sheet name
	 * @param sheetName
	 */
	public static Object[][] getTestData(String sheetName) {
		
		try {
			//To make connection with Sheet
			FileInputStream file= new FileInputStream(TESTDATA_SHEET_PATH);
			
			//workbook=WorkbookFactory.create(file); //it will local copy of excel file in java memory
			workbook=new XSSFWorkbook(file);
			sheet=workbook.getSheet(sheetName);
			
			Object data[][]= new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();		
				}
			}
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
