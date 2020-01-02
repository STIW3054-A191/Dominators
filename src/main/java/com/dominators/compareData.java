package com.dominators;

import java.util.ArrayList;

public class compareData {

    public void compareData(ArrayList<Data> mainIssue, ArrayList <Data> wiki){
        for(int i = 0; i < 28; i++){

            for(int j = 0; j < wiki.size(); j++){
                if(mainIssue.get(i).getMatric().equals(wiki.get(j).getMatric())) {

                    wiki.get(j).setLink(mainIssue.get(i).getLink());
                    wiki.get(j).setCbo(mainIssue.get(i).getCbo());
                    wiki.get(j).setDit(mainIssue.get(i).getDit());
                    wiki.get(j).setLcom(mainIssue.get(i).getLcom());
                    wiki.get(j).setNoc(mainIssue.get(i).getNoc());
                    wiki.get(j).setRfc(mainIssue.get(i).getRfc());
                    wiki.get(j).setWmc(mainIssue.get(i).getWmc());
                }
            }

        }

    }
}
