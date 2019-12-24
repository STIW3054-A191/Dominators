package main.java;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.DefaultFontMapper;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PieChartDemo {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.setValue(190, "LaptopUsers", "1995");
        defaultCategoryDataset.setValue(205, "LaptopUsers", "2000");
        defaultCategoryDataset.setValue(300, "LaptopUsers", "2005");
        defaultCategoryDataset.setValue(350, "LaptopUsers", "2010");
        defaultCategoryDataset.setValue(390, "LaptopUsers", "2015");

        JFreeChart jFreeChart = ChartFactory.createBarChart(
                "LaptopUsers BarChart", //title
                "Year", // categoryAxisLabel
                "LaptopUsers", //valueAxisLabel
                defaultCategoryDataset, //dataset
                PlotOrientation.VERTICAL, //orientation
                false, false, false); //legend, tooltips and urls


        String pdfFilePath = "E:/BAR CHART created in pdf in java using iText.pdf";
        OutputStream fos = new FileOutputStream(new File(pdfFilePath));
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, fos);

        document.open();

        PdfContentByte pdfContentByte = writer.getDirectContent();
        int width = 400; //width of BarChart
        int height = 300; //height of BarChart
        PdfTemplate pdfTemplate = pdfContentByte.createTemplate(width, height);

        //create graphics
        Graphics2D graphics2d = pdfTemplate.createGraphics(width, height,
                new DefaultFontMapper());

        //create rectangle
        java.awt.geom.Rectangle2D rectangle2d = new java.awt.geom.Rectangle2D.Double(
                0, 0, width, height);

        jFreeChart.draw(graphics2d, rectangle2d);

        graphics2d.dispose();
        pdfContentByte.addTemplate(pdfTemplate, 40, 500); //0, 0 will draw BAR chart on bottom left of page

        document.close();
        System.out.println("PDF created in >> " + pdfFilePath);
    }

}