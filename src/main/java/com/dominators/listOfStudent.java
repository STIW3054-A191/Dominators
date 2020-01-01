package com.dominators;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class listOfStudent {

    //Create ArrayList to store data
    private final ArrayList<Data> data = new ArrayList<Data>();

    public void scrapeDataWiki() throws IOException {
        String URL = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
        Document doc = Jsoup.connect(URL).get();
        Elements table = doc.select("table");

        for(int i = 0; i<=35; i++){

            //Get elements using CSS Selectors.
            Elements matric = table.select("tbody > tr:nth-child(" + i + ") > td:nth-child(2)");
            Elements name = table.select("tbody > tr:nth-child(" + i + ") > td:nth-child(3)");


            //Assigning attributes to an object and adding the object into the ArrayList.
            data.add(new Data(matric.text(),name.text(),matric.text()));

        }
    }

    //Returns the ArrayList.
    public ArrayList<Data> arrayList(){
        return data;
    }

}
