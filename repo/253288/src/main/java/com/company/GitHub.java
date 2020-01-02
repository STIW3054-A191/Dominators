package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GitHub {
    private final String githubLink = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
    private final String Matric = "Matric: ";
    private final String Matric1 = "Matric:";
    private final String Matric2 = "Matric : ";
    private final String Matric3 = "matrix :";
    private final String Matric4 = "Matric no: ";
    private Document doc;
    private compare compare;
    private int total;


    public void showAcc() {
        compare = new compare();

        try {
            doc = Jsoup.connect(githubLink).get();
            System.out.println("");
            System.out.println("Student Submit The Github Account: ");


            Elements links = doc.getElementsByClass("js-timeline-item js-timeline-progressive-focus-container");
            for (Element link : links) {
                final String theLink = link.getElementsByTag("p").text();
                if (compare.isMatch(Matric, theLink) == true) {
                    System.out.println(theLink);
                    total++;
                } else if (compare.isMatch(Matric1, theLink) == true) {
                    System.out.println(theLink);
                    total++;
                } else if (compare.isMatch(Matric2, theLink) == true) {
                    System.out.println(theLink);
                    total++;
                }else if (compare.isMatch(Matric3, theLink) == true) {
                    System.out.println(theLink);
                    total++;
                }else if (compare.isMatch(Matric4, theLink) == true) {
                    System.out.println(theLink);
                    total++;
                }
            }

            System.out.println("Total students submit to GitHub Account = " + total);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}




