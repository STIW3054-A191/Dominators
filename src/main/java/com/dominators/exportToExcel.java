package com.dominators;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class exportToExcel implements Print {
    String[] header={"No.","Matric","Name","WMC","DIT","NOC","CBO","RFC","LCOM"};


    @Override
    public void printData(ArrayList<Data> arrayList){
        // Create a Workbook.
        Workbook workbook = new XSSFWorkbook();
        // Create Submitted Sheet.
        Sheet sheet1 = workbook.createSheet("ckjmResult");

        // Create a Font for styling header cells.
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 16);


        // Create a CellStyle with the font.
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);


        //set border style for header cells.
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);

        //set text to center.
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);


        //create a  CellStyle with border.
        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);

        //Create row.
        Row headerRow = sheet1.createRow(0);

        // Create cells.
        for (int i = 0; i < header.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(headerCellStyle);

        }

        // Print data to row.
        int rowNum = 1;
        for(int i=0;i<28;i++){
            Data followerTable = arrayList.get(i);
//        for (Data followerTable : arrayList)
            Row row = sheet1.createRow(rowNum++);


            Cell column1 = row.createCell(0);
            column1.setCellValue((rowNum-1));
            column1.setCellStyle(cellStyle);

            Cell column2 = row.createCell(1);
            column2.setCellValue(followerTable.getMatric());
            column2.setCellStyle(cellStyle);

            Cell column3 = row.createCell(2);
            column3.setCellValue(followerTable.getName());
            column3.setCellStyle(cellStyle);

            Cell column4 = row.createCell(3);
            column4.setCellValue(followerTable.getWmc());
            column4.setCellStyle(cellStyle);

            Cell column5 = row.createCell(4);
            column5.setCellValue(followerTable.getDit());
            column5.setCellStyle(cellStyle);

            Cell column6 = row.createCell(5);
            column6.setCellValue(followerTable.getNoc());
            column6.setCellStyle(cellStyle);

            Cell column7 = row.createCell(6);
            column7.setCellValue(followerTable.getCbo());
            column7.setCellStyle(cellStyle);

            Cell column8 = row.createCell(7);
            column8.setCellValue(followerTable.getRfc());
            column8.setCellStyle(cellStyle);

            Cell column9 = row.createCell(8);
            column9.setCellValue(followerTable.getLcom());
            column9.setCellStyle(cellStyle);

        }

        // Resize all columns to fit the content size.
        for (int i = 0; i < header.length; i++) {
            sheet1.autoSizeColumn(i);
        }




        // Write the output to a file.
        try {
        FileOutputStream fileOut = new FileOutputStream("Report.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        //Message for processing excel file.
        System.out.println("\n\n\n"+"Generating an Excel file for the report..");
        Thread.sleep(2000);
        System.out.println("An Excel file named 'Report' has been generated.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
