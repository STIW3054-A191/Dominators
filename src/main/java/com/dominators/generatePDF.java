package com.dominators;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class generatePDF {
    public void generate(ArrayList<Data>  arrayList,String directory) throws FileNotFoundException, DocumentException {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for(Data data: arrayList) {
            defaultCategoryDataset.setValue(data.getWmc(), "WMC", data.getMatric());
            defaultCategoryDataset.setValue(data.getDit(), "DIT", data.getMatric());
            defaultCategoryDataset.setValue(data.getNoc(), "NOC", data.getMatric());
            defaultCategoryDataset.setValue(data.getCbo(), "CBO", data.getMatric());
            defaultCategoryDataset.setValue(data.getRfc(), "RFC", data.getMatric());
            defaultCategoryDataset.setValue(data.getLcom(), "LCOM", data.getMatric());
        }

        JFreeChart jFreeChart = ChartFactory.createBarChart(
                "CKJM Result", //title
                "Matric", // categoryAxisLabel
                "Value", //valueAxisLabel
                defaultCategoryDataset, //dataset
                PlotOrientation.HORIZONTAL, //orientation
                true, false, false); //legend, tooltips and urls


        String pdfFilePath = directory+"/ckjm.pdf";
        OutputStream fos = new FileOutputStream(new File(pdfFilePath));
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, fos);

        document.open();

        PdfContentByte pdfContentByte = writer.getDirectContent();
        int width = 500; //width of BarChart
        int height = 800; //height of BarChart
        PdfTemplate pdfTemplate = pdfContentByte.createTemplate(width, height);

        //create graphics
        Graphics2D graphics2d = pdfTemplate.createGraphics(width, height,
                new DefaultFontMapper());

        //create rectangle
        java.awt.geom.Rectangle2D rectangle2d = new java.awt.geom.Rectangle2D.Double(
                0, 0, width, height);

        jFreeChart.draw(graphics2d, rectangle2d);

        graphics2d.dispose();
        pdfContentByte.addTemplate(pdfTemplate, 0, 0); //0, 0 will draw BAR chart on bottom left of page

        document.close();
        System.out.println("PDF created in >> " + pdfFilePath);
    }
 }

