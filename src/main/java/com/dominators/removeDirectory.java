package com.dominators;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class removeDirectory {

    public void removeDir() throws IOException {
        String directory = System.getProperty("user.dir");
        File repoDir = new File(directory+"/repo");
        File logDir = new File(directory+"/log");
        File outDir = new File(directory+"/output");
        File ckjmDir = new File(directory+"/CKJM");
        if(repoDir.exists()){
            FileUtils.deleteDirectory(repoDir);
        }
        if(logDir.exists()){
            FileUtils.deleteDirectory(logDir);
        }
        if(outDir.exists()){
            FileUtils.deleteDirectory(outDir);
        }
        if(ckjmDir.exists()){
            FileUtils.deleteDirectory(ckjmDir);
        }
    }
}
