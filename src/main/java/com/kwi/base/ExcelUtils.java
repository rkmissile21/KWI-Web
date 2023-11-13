package com.kwi.base;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ExcelUtils {

    HSSFWorkbook wb = null;
    HSSFSheet sheet = null;
    int numberOfRows, numberOfCol;

    // Main method for testing the ExcelUtils class
    public static void main(String[] args) throws IOException {
        ExcelUtils excelReader = new ExcelUtils();

        // Test: Retrieve a specific data point from the Excel sheet
        System.out.println("Specific Data********");
        String specificData = excelReader.getValueOf("src/test/resources/Book.xls", 0, 1);
        System.out.println(specificData);

        // Test: Retrieve all data points from a specific row in the Excel sheet
        System.out.println("Specific Datas Of Row********");
        String[] specificRow = excelReader.getValueOf("src/test/resources/Book.xls", 0);
        for (int i = 0; i < specificRow.length; i++) {
            System.out.println(specificRow[i]);
        }
    }

    // Retrieve all data points from a specific column in the Excel sheet
    public String[] getValueOf(String path, int column) throws IOException {
        String[] data;

        // Read the Excel file
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(column).getLastCellNum();

        // Initialize data array
        data = new String[numberOfRows + 1];

        // Iterate through rows and columns to retrieve data
        for (int i = 1; i < data.length; i++) {
            HSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                HSSFCell cell = rows.getCell(j);
                String cellData = getCellValue(cell);
                data[i] = cellData;
            }
        }
        return data;
    }

    // Retrieve a specific data point from the Excel sheet
    public String getValueOf(String path, int column, int row) throws IOException {
        String data;

        // Read the Excel file
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();

        // Retrieve the specified cell data
        HSSFRow rows = sheet.getRow(row);
        HSSFCell cell = rows.getCell(column);
        String cellData = getCellValue(cell);
        data = cellData;

        return data;
    }

    // Get the cell value based on its data type
    private String getCellValue(HSSFCell cell) {
        Object value = null;
        int dataType = cell.getCellType();
        switch (dataType) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
        }
        return value.toString();
    }
}
