package com.baktajivan;
//imports
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Matric {
    private final String gitLink = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
    private Document doc;

    private static RegexMatches regexMatches = new RegexMatches();
    public static String[][]stdComm = new String[39][3];

    public static int nx = 0;
    public static int mx = 0;
    public static int ox = 0;


    public static void main(String[] args)
    {
        new Matric().Main();

        for (int x=0; x < stdComm.length;x++) {
            if(stdComm[x][0] == null) {

                stdComm[x][0] = " ";
                stdComm[x][1] = " ";
                stdComm[x][2] = " ";
            }//if

            else if(regexMatches.Regex("^ ", stdComm[x][1])) {

                stdComm[x][1] = stdComm[x][1].replaceAll("^ ","");
            }//else
        }//for
    }//main

    private void Main() {

        try {
            doc = Jsoup.connect(gitLink).get();//jsoup connect into link
            //String title = doc.title();
            Elements datalinks = doc.getElementsByClass("js-timeline-item js-timeline-progressive-focus-container").select("p");

            for (Element link : datalinks) {//split query
                String [] splitString=link.text().split(" ");

                for (int i = 0;i <splitString.length;i++) {

                    if (regexMatches.Regex("[0-9]",splitString[i]) && splitString[i].length()<=13) {
                        String[] splitText;

                        if (splitString[i].length()>6) {
                            splitText = splitString[i].split(":");

                            for (int j = 0;j<splitText.length;j++) {

                                if (splitText[j].length()==6 && regexMatches.Regex("[0-9]",splitText[j])) {
                                    stdComm[nx][0]=splitText[1];
                                    nx++;
                                }//if
                            }//for
                        }//for

                        else {
                            stdComm[nx][0]=splitString[i];
                            nx++;
                        }//else

                    }//if regex

                    else if (regexMatches.Regex("https",splitString[i])) {
                        String[] splitText;

                        if (regexMatches.Regex("Link",splitString[i])) {
                            splitText=splitString[i].split("ink:");

                            for (int k = 0; k<splitText.length;k++) {

                                if (splitText[k].length()>1) {
                                    stdComm[mx][2]= splitText[1];
                                    mx++;
                                }//if
                            }//for
                        }//if
                        else {
                            stdComm[mx][2]=splitString[i];
                            mx++;
                        }//elss
                    }//else if
                }//for

                //cont to split and store in array
                String[] split1 =link.text().split("Name");

                for(String a: split1) {
                    String[] split2 = a.split(":");

                    for(String b: split2) {
                        String[] split3 = b.split("Link");

                        for(String c: split3) {
                            String[] split4 = c.split("Matric no");

                            for (String d: split4) {
                                String[] split5= d.split("link");

                                for(String e: split5) {

                                    if(regexMatches.Regex("[a-zA-Z]",e)
                                            && !regexMatches.Regex("[0-9]",e)
                                            && !regexMatches.Regex("https",e)
                                            && !regexMatches.Regex("//",e)
                                            && !regexMatches.Regex("[Mm]atri[cx]",e))

                                    {
                                        stdComm[ox][1] = e;
                                        ox++;
                                    }//push e into ox
                                }//for s5
                            }//for s4
                        }//for s3
                    }//for s2
                }//for s1
            }//for elements
        }//try

        catch(IOException e)
        {
            e.printStackTrace();
        }//catch
    }//end main
}//class
