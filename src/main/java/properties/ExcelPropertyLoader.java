package properties;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelPropertyLoader {

	private static final String location = "TC.xlsx";

//	public static void main(String[] args) {
//		ExcelPropertyLoader loader = new ExcelPropertyLoader();
//		Map<String, String> properties = loader.loadProperty("chrome", "TC1");
//		System.out.println("Excel Properties: " + properties.toString());
//	}

	public Map<String, String> loadProperty(String browser,
			String testCase) {
		System.out.println("Input Browser: " + browser + " Test Case: " + testCase);
		Map<String, String> properties = new HashMap<String, String>();
		//DataFormatter dataFormatter = new DataFormatter();
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(new File(location));
			System.out.println("Workbook has " + workbook.getNumberOfSheets()
					+ " Sheets.");
			Sheet sheet = workbook.getSheet(browser);

			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				String firstCell = row.getCell(0).getStringCellValue();
//				System.out.println("1st cell: " + firstCell);
				if(testCase.equalsIgnoreCase(firstCell)){
					//System.out.println("Cell 1 - " + row.getCell(1) + " Cell 2 - " + row.getCell(2));
					properties.put(row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue());
				}
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

}
