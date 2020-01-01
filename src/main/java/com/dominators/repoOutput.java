package com.dominators;

import java.io.*;

public class repoOutput {
    private String matric, jarName;

    repoOutput(String matric, String jarName){
        this.matric = matric;
        this.jarName = jarName;
    }


    public void runRepoJar() throws IOException {
        String directory = System.getProperty("user.dir");
        try{
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", directory + "/repo/"+matric+"/target/"+jarName);
            Process p = pb.start();
            File file = new File(directory+"/output");
            file.mkdir();
            FileOutputStream outputFile = new FileOutputStream(directory+"/output/"+matric+".out");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = "";
            while((s = in.readLine()) != null){
                PrintStream printStream = new PrintStream(outputFile);
                printStream.println(s);
            }
        }catch(Exception e){
            System.out.println("");
        }

    }

}
