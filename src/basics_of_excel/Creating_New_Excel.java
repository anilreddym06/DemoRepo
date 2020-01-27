package basics_of_excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Creating_New_Excel {
	public static void main(String[] args) {
		Creating_Newexcel();
	}
	public static void Creating_Newexcel() {
		try {
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("details");
		XSSFRow row=sheet.createRow(1);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("ID");
		FileOutputStream fos=new FileOutputStream("E:\\SeleniumJava\\CogmentoAutomation\\newdata\\anil123.xlsx");		
			wb.write(fos);
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
