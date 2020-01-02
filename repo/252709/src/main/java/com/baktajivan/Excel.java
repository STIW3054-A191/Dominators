package com.baktajivan;
//imports
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {
    private static Compare compare = new Compare();

    //declare file name and file path
    private static final String FILE_NAME = "D://GitComm/RTAssig1/Assigment1.xlsx";

    //creating a workbook in excel with 3 sheets for better efficiency
    private static XSSFWorkbook workbook = new XSSFWorkbook();
    private static XSSFSheet sheet1 = workbook.createSheet("Students Submit");
    private static XSSFSheet sheet2 = workbook.createSheet("Students Not Submit");
    private static XSSFSheet sheet3 = workbook.createSheet("Unknown List");

    public static void main(String[] args ) {
        compare.main(args);
//declare object matching with the sheet
        Object[][] d1 = Compare.studDet;
        Object[][] d2 = Compare.studNum;
        Object[][] d3 = Compare.studlin;
        int cRow =0;
        System.out.println("Creating Excel File");
        rowList(sheet1, d1, cRow);
        rowList(sheet2, d2, cRow);
        rowList(sheet3, d3, cRow);

        try {
//for generating a database or file | write
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        }//try

        catch (IOException e) {
            e.printStackTrace();
        }//catch

        System.out.println("DONE");
    }//end main

    static void rowList(XSSFSheet sheet, Object[][] data, int cRow) {

        for (Object[] datatype : data) {

            Row row = sheet.createRow(cRow++);
            int colNum = 0;

            for (Object field : datatype) {

                Cell cell = row.createCell(colNum++);
                sheet.autoSizeColumn(cRow);

                if (field instanceof String) {

                    cell.setCellValue((String) field);
                } //if

                else if (field instanceof Integer) {

                    cell.setCellValue((Integer) field);
                }//else if
            }//for
        }//for

        for (int x = 0; x < sheet.getRow(0).getPhysicalNumberOfCells(); x++) {

            sheet.autoSizeColumn(x);
        }//for
    }//rowlist
}//class
