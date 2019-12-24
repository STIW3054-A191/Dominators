package com.dominators;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class checkDirectory {
    private String matricNo, jarname;

    checkDirectory(String matricNo){
        this.matricNo = matricNo;
    }

    public void checkDir(){
        String directory = System.getProperty("user.dir");

        File file = new File(directory+"/repo/"+matricNo+"/target");
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(file.list()));
        for(int i = 0; i < names.size(); i++){
            if(names.get(i).toString().contains(".jar")){
                jarname = names.get(i).toString();
            }
        }
    }

    public String getJarname(){
        return jarname;
    }

}
