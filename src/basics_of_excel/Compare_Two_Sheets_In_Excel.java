package basics_of_excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Compare_Two_Sheets_In_Excel {
	public static void main(String[] args) {
		Compare_two_sheets();
	}
	public  static void Compare_two_sheets() {
		
		try {
			FileInputStream fis=new FileInputStream("E:\\SeleniumJava\\CogmentoAutomation\\newdata\\anil1236.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet1=wb.getSheet("company");
			XSSFSheet sheet2=wb.getSheet("company1");
			int totalrows=sheet1.getLastRowNum();
			for(int i=0;i<=totalrows;i++) {
				XSSFRow row=sheet1.getRow(i);
				XSSFRow row1=sheet2.getRow(i);
				int totalvalues=row.getLastCellNum();
				for(int j=0;j<=totalvalues-1;j++) {
					XSSFCell cell=row.getCell(j);
					XSSFCell cell1=row1.getCell(j);
					String cellvalue=cell.getStringCellValue();
					String cellvalue1=cell1.getStringCellValue();
					if(!cellvalue.trim().equalsIgnoreCase(cellvalue1.trim())) {
						System.out.println(+i+":>"+cellvalue+" "+j+":>"+cellvalue1);
						
					}
				}
			}
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
