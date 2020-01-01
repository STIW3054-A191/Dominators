package com.dominators;

public class Data {
    private int num, wmc,dit,noc,cbo,rfc,lcom;
    private String matric, name, link, jarName;

    public Data(){

    }

    //Constructor for Data from Issue Page (MainIssue).
    public Data(String column1, String column2, String column3) {

        this.matric = column1;
        this.name = column2;
    }

    //Constructor for Data from Wiki Page (ListOfStudent).
    public Data(String column1, String column2) {

        this.matric = column1;
        this.link = column2;
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

    public void setCbo(int cbo) {
        this.cbo = cbo;
    }

    public void setDit(int dit) {
        this.dit = dit;
    }

    public void setLcom(int lcom) {
        this.lcom = lcom;
    }

    public void setNoc(int noc) {
        this.noc = noc;
    }

    public void setRfc(int rfc) {
        this.rfc = rfc;
    }

    public void setWmc(int wmc) {
        this.wmc = wmc;
    }

    public int getCbo() {
        return cbo;
    }

    public int getDit() {
        return dit;
    }

    public int getLcom() {
        return lcom;
    }

    public int getNoc() {
        return noc;
    }

    public int getRfc() {
        return rfc;
    }

    public int getWmc() {
        return wmc;
    }

    public String getJarName() {
        return jarName;
    }

    public void setJarName(String jarName) {
        this.jarName = jarName;
    }
}
