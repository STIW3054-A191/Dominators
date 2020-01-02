package com.tanchengyi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class calcStudSubGHA {
    private String githubLink;
    private Document doc;
    private int total=0;
    private final String myString = "\\d{5,6}";
    private com.tanchengyi.regexMatches regexMatches;

    calcStudSubGHA(String githubLink){
        this.githubLink=githubLink;
    }

    public int calcStud(){
        regexMatches = new regexMatches();
        try {
            doc = Jsoup.connect(githubLink).get();

            // get students who submitt github account
            Elements links = doc.select("p");
            for (Element link : links) {
                String theLink = link.text();
                if (regexMatches.isMatch(myString, theLink) == true) {
                    total++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

}
