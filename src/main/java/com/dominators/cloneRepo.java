package com.dominators;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;

public class cloneRepo implements Runnable{

    private String url, matricNo;

    cloneRepo(String url, String matricNo){
        this.url = url;
        this.matricNo = matricNo;
    }

    @Override
    public void run() {
        try {

            String directory = System.getProperty("user.dir");
            Git.cloneRepository()
                    .setURI(url + ".git")
                    .setDirectory(new File(directory+"/repo/" + matricNo))

                    .call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }
}
