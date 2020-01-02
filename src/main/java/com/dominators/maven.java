package com.dominators;

import org.apache.maven.cli.MavenCli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class maven {

    private String matricNo;

    maven(String matricNo){
        this.matricNo = matricNo;
    }

public void compile() throws FileNotFoundException {
    String directory = System.getProperty("user.dir");
    File file = new File(directory+"/log");
    file.mkdir();
    FileOutputStream buildLog = new FileOutputStream(directory+"/log/"+matricNo+".log");

    MavenCli cli = new MavenCli();
    cli.doMain(new String[]{"clean","install"}, directory+"/repo/"+matricNo, System.out, new PrintStream(buildLog));


}

}
