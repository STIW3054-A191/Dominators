package com.baktajivan;
//imports
import java.util.Arrays;

public class Compare {
    //init constructor
    private static StudentList studentTable = new StudentList();
    private static Matric studentInfo = new Matric();

    private static int totalCommented = 0;
    private static int totalNotCommented = 0;
    private static int totalAnonCommented = 0;

    private static String[] studList = new String[45];
    private static String[] matList = new String[39];
    private static String[] reList = new String[39];

    private static String[] Title = {"No.", "Matric", "Name", "Github Link"};
// array for info
    static String[][] studDet = new String[39][4];
    static String[][] studNum = new String[39][4];
    static String[][] studlin = new String[39][4];


    public static void main(String[] args) {
//link ke main class nak run this
        studentTable.main(args);
        studentInfo.main(args);


        for (int i = 0; i < StudentList.stdList.length; i++) {

            studList[i] = StudentList.stdList[i][0];
        }

        for (int i = 0; i < Matric.stdComm.length; i++) {

            matList[i] = Matric.stdComm[i][0];
        }

        for (int i = 0; i < Matric.stdComm.length; i++) {
            //differentiating which data goes to where
            if (Arrays.asList(studList).contains(Matric.stdComm[i][0]) && !Matric.stdComm[i][0].equals(" ")) {
                //total comments
                studDet[0] = Title;
                studDet[totalCommented + 1][0] = String.valueOf(totalCommented + 1);
                studDet[totalCommented + 1][1] = Matric.stdComm[i][0];
                studDet[totalCommented + 1][2] = Matric.stdComm[i][1];
                studDet[totalCommented + 1][3] = Matric.stdComm[i][2];
                totalCommented++;
            }
            //anonymous comment
            else if (!Arrays.asList(studList).contains(Matric.stdComm[i][0]) && !Matric.stdComm[i][0].equals(" ")) {

                studNum[0] = Title;
                studNum[totalAnonCommented + 1][0] = String.valueOf(totalAnonCommented + 1);
                studNum[totalAnonCommented + 1][1] = Matric.stdComm[i][0];
                studNum[totalAnonCommented + 1][2] = Matric.stdComm[i][1];
                studNum[totalAnonCommented + 1][3] = Matric.stdComm[i][2];
                totalAnonCommented++;
            }
            //not commented
            else if (!Arrays.asList(matList).contains(StudentList.stdList[i][0]) && StudentList.stdList[i][0] != null && !StudentList.stdList[i][0].equals("254660")) {

                studlin[0] = Title;
                studlin[totalNotCommented + 1][0] = String.valueOf(totalNotCommented + 1);
                studlin[totalNotCommented + 1][1] = StudentList.stdList[i][0];
                studlin[totalNotCommented + 1][2] = StudentList.stdList[i][1];
                studlin[totalNotCommented + 1][3] = "Not Submitted";
                totalNotCommented++;
            }
        }

        for (int i = 0; i < StudentList.stdList.length; i++) {
            //breaking it down
            if (!Arrays.asList(matList).contains(StudentList.stdList[i][0]) && StudentList.stdList[i][0] != null && !StudentList.stdList[i][0].equals("254660")) {

                studlin[0] = Title;
                studlin[totalNotCommented + 1][0] = String.valueOf(totalNotCommented + 1);
                studlin[totalNotCommented + 1][1] = StudentList.stdList[i][0];
                studlin[totalNotCommented + 1][2] = StudentList.stdList[i][1];
                studlin[totalNotCommented + 1][3] = "Not Submitted";
                totalNotCommented++;
            }
        }
//prints all student details
        System.out.println("List of Student Submit");
        String[] priList = reList(studDet);

        for (int i = 0; i < reList.length; i++) {

            if (priList[i] != null) {
                System.out.println(priList[i]);
            }
        }

        clear(priList);
        //prints students who does not submit
        System.out.println("\nList of Student Not Submit");
        priList = reList(studlin);

        for (int i = 0; i < reList.length; i++) {

            if (priList[i] != null) {

                System.out.println(priList[i]);
            }
        }

        clear(priList);
        //prints students who are unknown @ anonymous
        System.out.println("\nList of Unknown Submit");
        priList = reList(studNum);

        for (int i = 0; i < reList.length; i++) {

            if (priList[i] != null) {
                System.out.println(priList[i]);
            }
        }
    }

    private static String[] reList(String[][] list) {
        //this class for format printing
        for (int i = 0; i < list.length; i++) {

            if (i == 1) {

                reList[i] = String.format("|%5s|%8s|%39s|%40s|", "-----", "--------", "---------------------------------------", "----------------------------------------");
            }

            else if (i == 0 && list[i][0] != null) {

                reList[i] = String.format("| %-4s| %-7s| %-38s| %-39s|", list[i][0], list[i][1], list[i][2], list[i][3]);
            }

            else if (list[i - 1][0] != null) {

                reList[i] = String.format("| %-4s| %-7s| %-38s| %-39s|", list[i - 1][0], list[i - 1][1], list[i - 1][2], list[i - 1][3]);
            }
        }

        return reList;
    }

    private static void clear(String[] s)
    {
        Arrays.fill(s, null);
    }
}
