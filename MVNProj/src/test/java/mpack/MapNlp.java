package mpack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MapNlp {
	public static Map<String, String> GetValueAndCreateMap(String uniqueValue,String sheetName) throws IOException{
		Map<String,String> mapCreation=new LinkedHashMap<String,String>();
		FileInputStream file=new FileInputStream("C:\\Users\\ADMIN\\Downloads\\Protectt.AI.xlsx");
		Workbook work=new XSSFWorkbook(file);
		Sheet sheet=work.getSheet(sheetName);
		CellAddress adress=findCellAdress(sheet,uniqueValue);
		System.out.println("Address "+adress);
		int rowNumber=adress.getRow();
		int columNumber=sheet.getRow(rowNumber).getPhysicalNumberOfCells();
		for(int i=0;i<columNumber;i++) {
			for(int j=rowNumber-1;j<rowNumber;j++) {
				j=rowNumber-1;
				mapCreation.put(sheet.getRow(j).getCell(i).getStringCellValue(),sheet.getRow(j+1).getCell(i).getStringCellValue());
			}
		}
		return mapCreation;
		}
		
private static CellAddress findCellAdress(Sheet sheet, String uniqueValue) {
	 for (Row row : sheet) {
           for (Cell cell : row) {
               if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(uniqueValue)) {
                   return cell.getAddress();
               }
           }
       }
       return null;
}
	
	public static void main(String[] args) throws IOException {
		String sheetName="MyBank";
		String uniqueValue="Developer Mode Enable Check";
		Map mapContainer=MapNlp.GetValueAndCreateMap(uniqueValue,sheetName);
		System.out.println(mapContainer);
//		String value=(String) mapContainer.get("AppPackage");
//		System.out.println(value);
	}

}
