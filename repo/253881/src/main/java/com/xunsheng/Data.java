package com.xunsheng;

public class Data {
    private int num;
    private String matric, name, link;

    //Default Constructor
    public Data(){

    }



    //Constructor for Data from Issue Page (MainIssue).
    public Data(String column1, String column2, String column3) {

        this.matric = column1;
        this.name = column2;
        this.link = column3;
    }

    //Constructor for Data from Wiki Page (ListOfStudent).
    public Data(String column1, String column2) {

        this.matric = column1;
        this.name = column2;
    }

    //Return the index of the element.
    public int getNum() {
        return num;
    }

    //Set the index of the element.
    public void setNum(int num) {
        this.num = num;
    }

    //Return the matric number of the element.
    public String getMatric() {
        return matric;
    }

    //Set the matric number of the element.
    public void setMatric(String column1) {
        this.matric = column1;
    }

    //Return the name of the element.
    public String getName() {
        return name;
    }

    //set the name of the element.
    public void setName(String column2) {
        this.name = column2;
    }

    //Return the link of github of the element.
    public String getLink() {
        return link;
    }

    //set the link of github of the element.
    public void setLink(String column3) {
        this.link = column3;
    }
}
