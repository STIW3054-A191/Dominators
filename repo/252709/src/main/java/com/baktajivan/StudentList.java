package com.baktajivan;
//imports
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class StudentList {

        public static String[][] stdList = new String[45][2];
        private static RegexMatches regexMatches = new RegexMatches();
        private static int x = 0;
        private static int y = 0;


        public static void main(String[] args) {

            new StudentList().Main();
        }

        private void Main() {
            regexMatches = new RegexMatches();


//process on retrieving the table of student list
            try {
                //connection
                String gitLink = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
                Document doc = Jsoup.connect(gitLink).get();

                Elements links = doc.getElementsByClass("markdown-body").select("td");

                for (Element link : links) {
                    //split query
                    if (link.text().length() == 6 && regexMatches.Regex("[0-9]", link.text()) && x < stdList.length) {

                        stdList[x][0] = link.text();
                        x++;
                    }//if

                    else if (regexMatches.Regex("[a-zA-Z]", link.text()) && y < stdList.length) {

                        stdList[y][1] = link.text();
                        y++;
                    }//else if
                }//for
            }//try

            catch (IOException e)
            {
                e.printStackTrace();
            }//catch
        }//end main
    }//class

