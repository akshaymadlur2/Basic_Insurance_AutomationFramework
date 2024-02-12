package resuableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	String filepath;
	Sheet sh;
	public ExcelOperations(String sheetName)  {
		// TODO Auto-generated constructor stub
		//location
			try {
				filepath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValuesbyKey("testDataLocation");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			//open file - workbook
			File testDataFile = new File(filepath);
			Workbook wb = null;
			try {
				wb = WorkbookFactory.create(testDataFile);
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			 sh=wb.getSheet(sheetName);
	}
	
public HashMap<String, String> getTestDataInMap(int rowNum) throws Exception {
	
	//Loction of excel file
	
	//sh.getRow(0).getCell(1).toString();
	//read data row by row and put it in hash map
	HashMap<String, String> hm= new HashMap<String, String>();
	for (int i = 0; i <sh.getRow(0).getLastCellNum(); i++) {
		sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
		hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		
	}
	return hm;
	
	
	
}
//public static void main(String[] args) throws Exception {
//	ExcelOperations e = new ExcelOperations();
//	System.out.println(e.getTestDataInMap(2));
//	}
//get row count
public int getRowCount() {
	return sh.getLastRowNum();
	}
//get col count
public int getColCount() {
	return sh.getRow(0).getLastCellNum();
}
}
