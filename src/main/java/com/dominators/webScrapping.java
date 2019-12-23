package com.dominators;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class webScrapping {

    public static void main(String[] args) {

        final String url = "https://github.com/STIW3054-A191/Assignments/issues/1";

        try {
            final Document document = Jsoup.connect(url).get();
            Elements info = document.getElementsByClass("d-block comment-body markdown-body  js-comment-body");
            Object object = new Object();
            for (Element Info:info) {
                String link = Info.getElementsByTag("a").attr("abs:href");
                //System.out.println(link);
                object.setUrlLink(link);
            }

//            thread T1 = new thread(object);
//            T1.run();
        }
        catch(Exception ex){
                ex.printStackTrace();
            }
        }
}
