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
	public String readDataFromPropertiesFile(String key) throws Throwable
	{
		fis=new FileInputStream(Constants.propertiesFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		
		return value;
	}
	
	public Object readDataFromExcel(String sheetName,int rowNo,int cellNo) throws Throwable
	{
		Object value=null;
		
		fis=new FileInputStream(Constants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row ro = sh.getRow(rowNo);
		Cell ce = ro.getCell(cellNo);
		CellType cellType = ce.getCellTypeEnum();
		
		if(cellType.equals("STRING"))
		{
			 value = ce.getStringCellValue();
		}
		else if(cellType.equals("NUMBER"))
		{
			 value = ce.getNumericCellValue();
		}
		
		return value;
	}
	
	public void writeDataIntoExcelSheet(String sheetName,int rowNo,int cellNo,String value) throws Throwable
	{
		
		fis=new FileInputStream(Constants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		if(sh.getRow(rowNo)==null)
		{
			sh.createRow(rowNo);
		}
		
		Row ro = sh.getRow(rowNo);
		Cell ce = ro.createCell(cellNo);
		ce.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(Constants.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
}
