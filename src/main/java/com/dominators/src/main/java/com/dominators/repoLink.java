package com.dominators;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class repoLink {

    //Create ArrayList to store data
    private final ArrayList<Data> data = new ArrayList<Data>();

    public void scrapeDataMI() throws IOException {
        String URL = "https://github.com/STIW3054-A191/Assignments/issues/1";
        Document doc = Jsoup.connect(URL).get();
        Elements table = doc.select("td.d-block.comment-body.markdown-body.js-comment-body");


        for (Element tableNum:table){


            //Get String that is needed using regex.
            String matricTrial = tableNum.getElementsMatchingOwnText("\\d{5,6}").text();

            String matric;
            String link;

            //Splitting and assigning values to attributes.
            Pattern matricPattern = Pattern.compile("(\\d{5,6})");
            Pattern linkPattern = Pattern.compile("(https://github.com/.+)");


            Matcher matcher1 = matricPattern.matcher(matricTrial);
            Matcher matcher2 = linkPattern.matcher(matricTrial);


            if ((matcher1.find()) && (matcher2.find())){
                matric = matcher1.group(1).trim();
                link = matcher2.group(1).trim();



                //Assigning attributes to an object and adding the object into the ArrayList.
                data.add(new Data(matric, link));


            }


        }
    }

    //Returns the ArrayList.
    public ArrayList<Data> arrayList(){
        return data;
    }
}
