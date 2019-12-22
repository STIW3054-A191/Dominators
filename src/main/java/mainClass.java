import java.io.*;

public class mainClass {
    public static void main(String[] args){

        File fileName = new File("/Users/hi/Desktop/txtOutput/" + "output"+".txt");
        int newfileName =1;
        while (fileName.exists()){
            newfileName++;
            fileName = new File("/Users/hi/Desktop/txtOutput/" + "output"+ newfileName +".txt");
        }
        if(!fileName.exists()) {
            try {
                fileName.createNewFile();

//                PrintWriter outputStream = new PrintWriter(fileName);
//                outputStream.println("Should get a output");
//                outputStream.close();

                FileWriter fw = new FileWriter(fileName.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("abc");
                bw.close();
                System.out.println("Done");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
