package Genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getCellValue(String path, String sheet, int r, int c) throws Exception{
		String cellvalue= "";
		
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			cellvalue=wb.getSheet(sheet).getRow(r).getCell(c).toString();
			
		}catch (Exception e)
		{
			
		}
		
		return cellvalue;	
	
		}
	public static int getRowCount(String path, String sheet ){
		int rowcount = 0;
		
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			rowcount = wb.getSheet(sheet).getLastRowNum();
			
		} catch (Exception e) {
			
		}	
		
		return rowcount;
		
	}

public static void setResult(String path,String sheet,int r,int c, String status){
		try{
			
			FileInputStream fis=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);		
			Cell cl = wb.getSheet(sheet).getRow(r).createCell(c);//create cell when the cell is blank and needs to write value
			cl.setCellValue(status); //overwrite the cell value
			FileOutputStream fos =new FileOutputStream(new File(path));		
			wb.write(fos); //save the excel sheet
		}
		catch(Exception e){}
	} 

}
