# Dominators

## Table of Contents
1. [Group Info](#group-info)
1. [Introduction](#introduction)
1. [Result/Output](#resultoutput)
1. [UML Class Diagram](#uml-class-diagram)
1. [YouTube Presentation](#youtube-presentation)
1. [References](#references)

## Group Info
1. Ong Xun Sheng 253881
2. Tan Cheng Yi  253814
3. Gan Lian Jie 255108
4. Yeong Shyh Haw 254772
5. Eng Pei Pei 254251

## Introduction
The instructions of this project are as follow:

You are required to develop a real-time system using the Java programming language (Maven). The system should be able to:

1. Get a list of repositories from Github Issues. Refer to the link below for the testing purpose.  
   https://github.com/STIW3054-A191/Assignments/issues/1

2. Download all the repositories from the list to your computer/laptop using Java threads.

3. Compile the Java program for each repository. If the Java program cannot be compiled, send the error messages to a log file. The name of the log file MUST follow the following format. 
>MatricNo.log (Example: 123456.log)

4. Run the program and store the output in a text file. The name of the output file MUST follow the following format. 
>MatricNo.out (Example: 123456.out)

5. Generate software metrics using CKJM (https://www.spinellis.gr/sw/ckjm/) for each Java program and store the result in a text file. The name of the text file MUST follow the following format. 
>MatricNo.txt (Example: 123456.txt)

6. Store the accumulative metrics for all the Java programs in MS Excel. The example of the reporting format is shown below:

| No. | Matric | Name                             | WMC  | DIT | NOC | CBO | RFC | LCOM |
|-----|--------|----------------------------------|------|-----|-----|-----|-----|------|
| 1   | 243147 | Yao Yangjian                     | 67   | 103 | xx  | xx  | xx  | xx   |
| 2   | 245607 | Siti Nur Fatihah Binti Fauzi     | 203  | 59  | xx  | xx  | xx  | xx   |

7. Generate a bar graph for each metric from the excel file and store all the graphs in a pdf file.

8. Calculate the execution time.

## Result/Output
### Project Folder
![Project Folder](https://user-images.githubusercontent.com/38216203/71661662-eab94000-2d89-11ea-88a3-ef01792e12d3.jpeg)
### Repository Folder
![Repo Folder](https://user-images.githubusercontent.com/38216203/71661664-ec830380-2d89-11ea-9d60-acd306534521.jpeg)
### Log Folder
![Log](https://user-images.githubusercontent.com/38216203/71661669-edb43080-2d89-11ea-936c-06f07b2ef55d.jpeg)
### Output Folder
![Output](https://user-images.githubusercontent.com/38216203/71661671-ef7df400-2d89-11ea-8e0f-5e71530c22ee.jpeg)
### CKJM Folder
![CKJM](https://user-images.githubusercontent.com/38216203/71661672-f0af2100-2d89-11ea-9ca4-907fd614a10b.jpeg)
### Excel File
![Excel](https://user-images.githubusercontent.com/38216203/71661673-f3aa1180-2d89-11ea-956c-e1395c6479c5.jpeg)
### Graph
![Graph](https://user-images.githubusercontent.com/38216203/71661678-f4db3e80-2d89-11ea-96c7-66e0057f3d84.jpeg)

## UML Class Diagram
![classD](https://user-images.githubusercontent.com/46247836/71662414-64522d80-2d8c-11ea-99f8-3e828ef456a0.png)

## YouTube Presentation

## References
<br>1. ArrayList (Java Platform SE 8 ). (n.d.). Retrieved from Oracle Help Center: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
<br><br>2. Element (jsoup Java HTML Parser 1.12.1 API). (n.d.). Retrieved from jsoup Java HTML Parser, with best of DOM, CSS, and jquery: https://jsoup.org/apidocs/org/jsoup/nodes/Element.html
<br><br>3. Pattern (Java Platform SE 7 ). (n.d.). Retrieved from Oracle Help Center: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
<br><br>4. Use selector-syntax to find elements: jsoup Java HTML parser. (n.d.). Retrieved from jsoup Java HTML Parser, with best of DOM, CSS, and jquery: https://jsoup.org/cookbook/extracting-data/selector-syntax
<br><br>5. YellowRose. (n.d.). Add Border to Excel Cell - Java POI Example Program | ThinkTibits! Retrieved from ThinkTibits!: https://thinktibits.blogspot.com/2012/12/Excel-Add-Cell-Border-Java-POI-Example-Program.html
<br><br>6. Singh, R. (2017, December 24). How to Write to an Excel file in Java using Apache POI | CalliCoder. Retrieved from CalliCoder | Programming, Web & Desktop App Development Tutorials: https://www.callicoder.com/java-write-excel-file-apache-poi/
<br><br>7. Shah, A. (n.d.). How to Run Multiple Threads Concurrently in Java? ExecutorService Approach • Crunchify. Retrieved from Crunchify • Largest free Technical and Blogging resource site for Beginner. We help clients transform their great ideas into reality!: https://crunchify.com/how-to-run-multiple-threads-concurrently-in-java-executorservice-approach/
<br><br>8. Vogella(2019) JGit - Tutorial. Retrieved from https://www.vogella.com/tutorials/JGit/article.html
<br><br>9. JFreeChart. Retrieved from http://www.jfree.org/jfreechart/
<br><br>10. The Leading PDF Platform for Developers | iText. Retrieved from https://itextpdf.com/en
