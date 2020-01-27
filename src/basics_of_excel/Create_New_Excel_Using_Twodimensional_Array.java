package basics_of_excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Create_New_Excel_Using_Twodimensional_Array {
	public static void main(String[] args) {
		create_new_Excel_using_twodimesionl_array();
	}
	public static void create_new_Excel_using_twodimesionl_array() {
		String[][]allvalues=new String[3][3];
		allvalues[0][0]="a1";
		allvalues[0][1]="a2";
		allvalues[0][2]="a3";
		allvalues[1][0]="b1";
		allvalues[1][1]="b2";
		allvalues[1][2]="b3";
		allvalues[2][0]="c1";
		allvalues[2][1]="c2";
		allvalues[2][2]="c3";
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("company");
		for(int i=0;i<=allvalues.length-1;i++){
		XSSFRow row=sheet.createRow(i);
		for(int j=0;j<=allvalues.length-1;j++) {
			XSSFCell cell=row.createCell(j);
			cell.setCellValue(allvalues[i][j]);
		}
		}
			
				
				try {
					FileOutputStream fos=new FileOutputStream("E:\\SeleniumJava\\CogmentoAutomation\\newdata\\anil1236.xlsx");
					wb.write(fos);
					wb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
				
		
	}
	

}
