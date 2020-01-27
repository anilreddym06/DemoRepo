package basics_of_excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Data_Into_Existing_Excel_file {
	public static void main(String[] args) {
		write_data_into_existing_excel_file();
	}
	public static void write_data_into_existing_excel_file() {
		
		try {
			FileInputStream fis= new FileInputStream("E:\\SeleniumJava\\CogmentoAutomation\\newdata\\anil123.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet("details");
			XSSFRow row=sheet.createRow(0);
			XSSFCell cell=row.createCell(4);
			cell.setCellValue("HI amar");
			FileOutputStream fos=new FileOutputStream("E:\\SeleniumJava\\CogmentoAutomation\\newdata\\anil123.xlsx");
			wb.write(fos);
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

