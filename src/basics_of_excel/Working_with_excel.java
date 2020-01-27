package basics_of_excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Working_with_excel {
	public static void main(String[] args) {
		
	
	
	

		
		
		try {
			FileInputStream fis = new FileInputStream("E:\\SeleniumJava\\CogmentoAutomation\\newdata\\anil.xlsx");
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet("Sheet1");
			XSSFRow row=sheet.getRow(1);
			String cell=row.getCell(2).toString();//this method is used to retrive the cell value it is easy to code
			//String cellvalue=cell.getStringCellValue();//instead of this code write above code to ritrive the cell value//
			System.out.println(cell);
			wb.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	}
	

	


