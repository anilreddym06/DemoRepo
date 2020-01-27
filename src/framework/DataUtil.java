package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtil {
	
	public static HashMap<String, String> gettestcasedata(String filepath,String sheetname,String tcid){
		HashMap<String, String> tcData=new HashMap<>();
				
				try {
					FileInputStream fis= new FileInputStream(filepath);					
					XSSFWorkbook wb=new XSSFWorkbook(fis);
				try {
				XSSFSheet sheet=wb.getSheet(sheetname);//after you get the sheet you have to check weather the sheet is null or not so you have to write nullpointerexception by using try/catch//
				XSSFRow headerrow=sheet.getRow(0);
				XSSFRow testcaserow=ExcelUtil.Get_Test_Case_Row(sheet,tcid);
				int totalcolms=headerrow.getLastCellNum();
				for(int i=0;i<=totalcolms;i++) {
					XSSFCell headercell=headerrow.getCell(i);
					XSSFCell cellvalue=testcaserow.getCell(i);
					if(cellvalue==null) {
						tcData.put(headercell.toString(), "");
					}else {
						tcData.put(headercell.toString(), cellvalue.toString());
					}
				}
				}catch(NullPointerException ne) {
				 System.out.println("unable to read the data from data sheet. exception info:"+ne.getMessage());
				 
				}
				finally {
					wb.close();// if sheet is null  you must and should close the workbook.
				}
			
			}catch(FileNotFoundException ffe) {
				System.out.println("Given Data file :" +filepath+ "is not available .please check the path and  re-run");
				System.exit(0);
		  
		} catch (IOException e) {
			
			System.out.println("Given Data file :" +filepath+ "is not a valid  excel file .please check the path and  re-run");
			System.exit(0);
		}
		
				return tcData;
		

	}
	public static Properties getpropertiesfile(String filepath) throws IOException  {
		FileInputStream fis=new FileInputStream(filepath);
		Properties props=new Properties();
		props.load(fis);
		return props;
	}
	


}
