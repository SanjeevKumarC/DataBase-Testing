import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class compareSheet {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Vivek Nagarajan\\Downloads\\VIvek_ClearTrip.xlsx";
		FileInputStream fileInputStream = new FileInputStream(path);
		 XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet1 = workbook.getSheet("Sheet1");
		XSSFSheet sheet2 = workbook.getSheet("Sheet2");

		int row_size1 = sheet1.getPhysicalNumberOfRows();

		for (int j = 1; j < row_size1; j++) {
			String value1 = sheet1.getRow(j).getCell(7).getStringCellValue();
			String value2 = sheet2.getRow(j).getCell(7).getStringCellValue();
			if(value1.equalsIgnoreCase(value2))
				System.out.println("Same");
			else
				System.out.println("Not same");
		}
		workbook.close();
	}
}
