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
            Git.cloneRepository()
                    .setURI(url + ".git")
                    .setDirectory(new File("./"+matricNo))
                    .call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }
}
