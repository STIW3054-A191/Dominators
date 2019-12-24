package com.dominators;

import org.apache.maven.cli.MavenCli;

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
    FileOutputStream buildLog = new FileOutputStream(directory+"/repo/"+matricNo+"/Build.log");

    MavenCli cli = new MavenCli();
    cli.doMain(new String[]{"clean","install"}, directory+"/repo/"+matricNo, System.out, new PrintStream(buildLog));


}

}
