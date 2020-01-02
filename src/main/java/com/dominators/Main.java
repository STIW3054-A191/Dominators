package com.dominators;

import com.itextpdf.text.DocumentException;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static int processors=0;

    public static void main(String[] args) throws IOException, DocumentException {
	// write your code here
        long start = System.currentTimeMillis();
        String directory = System.getProperty("user.dir");
        removeDirectory removeDirectory = new removeDirectory();
        removeDirectory.removeDir();
        File repoDir = new File(directory+"/repo");
        repoLink rp = new repoLink();
        rp.scrapeDataMI();
        listOfStudent listOfStudent = new listOfStudent();
        listOfStudent.scrapeDataWiki();
        File file = new File(directory+ "/CKJM");
        file.mkdir();
        processors = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(processors);
        System.out.println("Cloning Repositories..");
        for(int i = 0; i < 28; i++){
            cloneRepo cloneRepo = new cloneRepo(rp.arrayList().get(i).getLink(),rp.arrayList().get(i).getMatric());
            executor.execute(cloneRepo);

        }
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()){

        }

        System.out.println("Compiling Program..");
        for(int i = 0; i < 28; i++){
            maven maven = new maven(rp.arrayList().get(i).getMatric());
            maven.compile();
        }
        System.out.println("Running Program..");
        for(int i = 0; i < 28; i++){
            checkDirectory checkDirectory = new checkDirectory(rp.arrayList().get(i).getMatric());
            checkDirectory.checkDir();
            repoOutput repoOutput = new repoOutput(rp.arrayList().get(i).getMatric(),checkDirectory.getJarname());
            repoOutput.runRepoJar();
        }
        System.out.println("Generating CKJM..");
        Lock lock = new ReentrantLock();
        for(int i = 0; i < 28; i++){

            File classpath = new File(directory+"/repo/"+rp.arrayList().get(i).getMatric()+"/target/classes");
            try{
                lock.lock();
                String[] arg;
                int j=0;
                String[] extension = {"class"};
                Collection files =  FileUtils.listFiles(classpath,extension,true);
                arg=new String[files.size()];
                for(Object o : files){
                    File file1= (File) o;
                    arg[j]=file1.getAbsolutePath();
                    j++;
                }
                MetricsFilter mf = new MetricsFilter();
                FileOutputStream outputFile1 = new FileOutputStream(directory+"/CKJM/"+rp.arrayList().get(i).getMatric()+".txt");
                PrintStream printStream = new PrintStream(outputFile1);
                CkjmOutputHandler outputHandler = new PrintPlainResults(printStream);
                mf.runMetrics(arg,outputHandler);
                int[] ckjm=mf.getCkjm();
                rp.arrayList().get(i).setWmc(ckjm[0]);
                rp.arrayList().get(i).setDit(ckjm[1]);
                rp.arrayList().get(i).setNoc(ckjm[2]);
                rp.arrayList().get(i).setCbo(ckjm[3]);
                rp.arrayList().get(i).setRfc(ckjm[4]);
                rp.arrayList().get(i).setLcom(ckjm[5]);
                printStream.close();
                lock.unlock();

            }catch (Exception e){
                FileOutputStream outputFile1 = new FileOutputStream(directory+"/CKJM/"+rp.arrayList().get(i).getMatric()+".txt");
                PrintStream printStream = new PrintStream(outputFile1);
                System.out.println("Could not find class file of "+rp.arrayList().get(i).getMatric());
                printStream.println("Could not find class file of "+rp.arrayList().get(i).getMatric());
                printStream.close();
            }
        }
        compareData compareData=new compareData();
        compareData.compareData(rp.arrayList(),listOfStudent.arrayList());
        exportToExcel exportToExcel=new exportToExcel();
        exportToExcel.printData(listOfStudent.arrayList());
        generatePDF generatePDF=new generatePDF();
        generatePDF.generate(listOfStudent.arrayList(),directory);

        long end=System.currentTimeMillis();
        System.out.println("Execution Time in Milisecond: " + (end-start));

    }
}
