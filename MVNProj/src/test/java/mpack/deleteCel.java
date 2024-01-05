package mpack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class deleteCel {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("config.properties"));
		} catch (IOException e) {
			Logger.getLogger(Level.SEVERE + " : " + e.getMessage());
		}

		try {
			FileInputStream ip = new FileInputStream("./TestData/searchBarData.xlsx");
			Workbook wb = WorkbookFactory.create(ip);
			Sheet sh = wb.getSheet("products");
			int rowCount = sh.getPhysicalNumberOfRows();
			int columnCount = sh.getRow(0).getPhysicalNumberOfCells();
			Integer columnIndex = 0;
			String columnValue = "";
			for (int i = 0; i < columnCount; i++) {
				columnValue = sh.getRow(0).getCell(i).toString();
				if (columnValue.equals("Header Tabs")) {
					columnIndex = i;
				}
			}
			for (int i = 1; i < rowCount; i++) {
				Cell cellData =sh.getRow(i).getCell(columnIndex, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				sh.getRow(i).getCell(columnIndex).setBlank();
				FileOutputStream out = new FileOutputStream("./TestData/searchBarData.xlsx");
				wb.write(out);
				out.close();
			}

			System.out.println("done");

		} catch (Exception e) {
			System.out.println("fail");
			System.out.println(e);
		}

	}

	

}
