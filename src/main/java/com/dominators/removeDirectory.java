package com.dominators;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class removeDirectory {

    public void removeDir() throws IOException {
        String directory = System.getProperty("user.dir");
        File repoDir = new File(directory+"/repo");
        if(repoDir.exists()){
            FileUtils.deleteDirectory(repoDir);
        }
    }
}
