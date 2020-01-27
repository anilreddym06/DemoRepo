package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static HashMap<String, String> getData(String filepath, String sheetname, String tcid) {
		HashMap<String, String> testcasedata = new HashMap<>();
		String fileExtension = FileUtils.getFilExtenion(filepath);
		if (fileExtension.equalsIgnoreCase("xlsx") || fileExtension.equalsIgnoreCase("xls")) {
			try {
				FileInputStream fis = new FileInputStream(filepath);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheet(sheetname);
				if (sheet != null) {

					XSSFRow testcaserow = Get_Test_Case_Row(sheet, tcid);
					if (testcaserow != null) {
						XSSFRow headerrow = sheet.getRow(0);// here we taking only headerrow cell values why because
															// hashmap<> contains only keys and values keys means all
															// header row cell values like
															// ID,NAME,CITY,MAILID,CONTACTNUM,DEPARTMENT....ect values
															// means row cell values like
															// tc-1,anil,bangalore,test@gmail.com,23455,ece//
						int totalcolms = headerrow.getLastCellNum();
						for (int i = 0; i <= totalcolms - 1; i++) {
							XSSFCell colheader = headerrow.getCell(i);
							XSSFCell cellvalue = testcaserow.getCell(i);// heare testcaserow already we get the row cell
																		// values in Get_Test_Case_Row(sheet,
																		// tcid)method see that method once here we gust
																		// taking that cellvalues in to hashmap<>
							// testcasedata.put(colheader, cellvalue);
							if (cellvalue == null) {
								testcasedata.put(colheader.toString(), "");
							} else {
								testcasedata.put(colheader.toString(), cellvalue.toString());
							}

						}

					} else {
						System.out.println("the testcase: " + tcid + "is not found in the sheet: " + sheetname);
					}
				}

				else {
					System.out.println("given sheet" + sheetname + "does not exist");
					wb.close();
					System.exit(0);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("the data file :" + filepath + "is not a valid excel fail");
			System.exit(0);
		}

		return testcasedata;

	}

	private static int get_Column_position(XSSFSheet sheet, String columnheader) {
		int colpos = -1;
		XSSFRow headerrow = sheet.getRow(0);
		int totalcells = headerrow.getLastCellNum();
		for (int i = 0; i <= totalcells - 1; i++) {
			XSSFCell cell = headerrow.getCell(i);
			String cellvalue = cell.getStringCellValue();
			if (cellvalue.equalsIgnoreCase(columnheader)) {
				colpos = i;
				break;
			}

		}
		return colpos;

	}

	public static XSSFRow Get_Test_Case_Row(XSSFSheet sheetname, String tcid) {
		XSSFRow row = null;
		int tc_id_col_position = get_Column_position(sheetname, "TC_ID");
		if (tc_id_col_position >= 0) {
			int totalrows = sheetname.getLastRowNum();
			for (int j = 1; j <= totalrows; j++) {
				try {
					XSSFRow rows = sheetname.getRow(j);
					XSSFCell cell = rows.getCell(tc_id_col_position);
					// String cellvalue=cell.getStringCellValue();
					if (cell.toString().trim().equalsIgnoreCase(tcid)) {
						row = rows;
						break;

					}

				} catch (NullPointerException ne) {
				}

			}

		} else {
			System.out.println("Test case id column is not found");
		}
		return row;
	}

}
