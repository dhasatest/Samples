package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadfromXL {

	public static void main(String[] args) throws IOException {

		String datafilepath = ".//Book.xlsx";
		FileInputStream inputstream = new FileInputStream(datafilepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet Sheet = workbook.getSheetAt(0);

			int rows = Sheet.getLastRowNum();
		int cols = Sheet.getRow(0).getLastCellNum();
		System.out.println("Rows :"+rows+" Cols "+ cols);

		for(int r=0; r<=rows; r++) {

			XSSFRow row = Sheet.getRow(r);
			for(int c=0; c<cols;c++) {
				XSSFCell cell = row.getCell(c);

				switch (cell.getCellType()){
				case STRING: System.out.print(cell.getStringCellValue() ); break;
				case NUMERIC: System.out.print(cell.getNumericCellValue());break;

				}
				System.out.print(" | ");
			}
			System.out.println();

		} 


	/*	Iterator iterator = Sheet.rowIterator();

		while(iterator.hasNext()){
			XSSFRow row = (XSSFRow) iterator.next();

			Iterator cellIterator = row.cellIterator();

			while(cellIterator.hasNext()) {
				XSSFCell cell = (XSSFCell) cellIterator.next();

				switch(cell.getCellType()) {

				case STRING: System.out.print(cell.getStringCellValue());break;
				case NUMERIC: System.out.print(cell.getNumericCellValue());break;

				}
				System.out.print(" | ");

			}
			System.out.println();

		}*/
		
		

	}

}
