package com.Tutorialsninja.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtil {

	FileInputStream fis;

	public String readDataFromPropertiesFile(String key) throws Throwable {
		fis = new FileInputStream(Constants.propertiesFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);

		return value;
	}

	public Object readDataFromExcel(String sheetName, int rowNo, int cellNo) throws Throwable {
		Object value = null;

		fis = new FileInputStream(Constants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		// sh.getLastRowNum();
		// sh.getRow(0).getLastCellNum();
		Row ro = sh.getRow(rowNo);
		Cell ce = ro.getCell(cellNo);
		CellType cellType = ce.getCellTypeEnum();

		if (cellType.equals("STRING")) {
			value = ce.getStringCellValue();
		} else if (cellType.equals("NUMBER")) {
			value = ce.getNumericCellValue();
		}

		return value;
	}
	
	
	// for getting date form excel to data provider

	public Object[][] getDataFromExcelToDataProvider(String sheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream(Constants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastrownum = sh.getLastRowNum();
		int lastcellnum = sh.getRow(0).getLastCellNum();
		//System.out.println("last row no is:"+lastrownum);
		//System.out.println("last cell no is:"+lastcellnum);

		Object[][] data = new Object[lastrownum][lastcellnum];

		for (int i = 0; i < lastrownum; i++) {
			Row ro = sh.getRow(i + 1);
			for (int j = 0; j < lastcellnum; j++) {
				Cell ce = ro.getCell(j);
				CellType cellType = ce.getCellTypeEnum();
				
				switch (cellType) {

				case STRING:

					data[i][j] = ce.getStringCellValue();

					break;

				case NUMERIC:
					data[i][j] = Integer.toString((int) ce.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j] = ce.getBooleanCellValue();
					break;

				}
				
			}
			}
		return data;
		

	}

	public void writeDataIntoExcelSheet(String sheetName, int rowNo, int cellNo, String value) throws Throwable {

		fis = new FileInputStream(Constants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		if (sh.getRow(rowNo) == null) {
			sh.createRow(rowNo);
		}

		Row ro = sh.getRow(rowNo);
		Cell ce = ro.createCell(cellNo);
		ce.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(Constants.excelFilePath);
		wb.write(fos);
		wb.close();
	}

}
