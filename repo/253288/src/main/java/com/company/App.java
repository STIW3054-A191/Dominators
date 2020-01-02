package com.company;

public class App
{
    public static void main(String[] args) {


        System.out.println("STIW3054 STUDENT LIST NAMES ");
        Student_List list = new Student_List();
        list.showList();
        System.out.println(" ");

        GitHub acc = new GitHub();
        acc.showAcc();
        System.out.println(" ");
        System.out.println(" ");


        String myString = " ";
        String matric = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
        Boolean result = new compare().isMatch(myString, matric);

        Excel save = new Excel();
        save.convertData();

        System.out.println(" ");
        System.out.println("Writing the info");
        System.out.println("Successfully convert to Excel");


    }

}

