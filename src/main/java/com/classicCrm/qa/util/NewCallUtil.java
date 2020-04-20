package com.classicCrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.classicCrm.qa.base.TestCrmBase;

public class NewCallUtil extends TestCrmBase
{
	public static Object[][] data;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static DataFormatter formatter;
	
	public static Object[][] getNewCallData(String sName)
	{
		try
		{
			File f = new File("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\util\\newCallTestData.xlsx");
			FileInputStream file = new FileInputStream(f);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(0).getLastCellNum());
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			
			
			for(int i =0;i<sheet.getLastRowNum();i++)
			{
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
				{
					formatter = new DataFormatter();
					data[i][k] = formatter.formatCellValue(sheet.getRow(i+1).getCell(k));
				}
			}
			
			//code to write the data and save it in excel file
			/*FileOutputStream fo = new FileOutputStream("F:\\Sep2019\\classicCrmPro\\src\\main\\java\\com\\classicCrm\\qa\\util\\testDeal.xlsx");
			workbook.write(fo);
			fo.close();*/
			
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		return data;
	}

}
