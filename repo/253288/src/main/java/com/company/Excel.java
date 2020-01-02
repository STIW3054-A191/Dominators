package com.company;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {
    public void convertData() {
        try{
            Student_List list = new Student_List();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Student");

            Row rowHeader = sheet.createRow(0);
            rowHeader.createCell(0).setCellValue("     No     ");
            rowHeader.createCell(1).setCellValue("     Matric     ");
            rowHeader.createCell(2).setCellValue("     Name     ");

            for (int i= 0;i <=2;i++){
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                rowHeader.getCell(i).setCellStyle(style);

            }
            int j = 1;
            for (Info info: list.showList()) {
                Row row = sheet.createRow(j);
                Cell Column1 = row.createCell(0);
                Column1.setCellValue(info.getColumn1());
                Cell Column2 = row.createCell(1);
                Column2.setCellValue(info.getColumn2());
                Cell Column3 = row.createCell(2);
                Column3.setCellValue(info.getColumn3());
                j++;
            }


            for (int i= 1;i<=35;i++)
                sheet.autoSizeColumn(i);

            FileOutputStream out= new FileOutputStream(new File("G:\\Student_List.xls"));
            workbook.write(out);
            out.close();
            workbook.close();
        }catch (IOException e)  {
            System.out.println(e.getStackTrace());

        }
    }
}
