package com.company;
import java.io.*;

public class Main {

    private static String findSequence (char[] inputSequence){
        char one='1';
        int currentSequence=0,maxSequence=0;

        for (int i = 0; i <inputSequence.length; i++) {
            if(one==inputSequence[i]) currentSequence++;
            else currentSequence=0;
            if(currentSequence>maxSequence) maxSequence=currentSequence;
        }
        return Integer.toString(maxSequence);

    }

    private static char[] readUsingFileWriter() {
        File file = new File("INPUT.txt");
        char[] inputSequence = new char[(byte) file.length()];
        try (FileReader reader = new FileReader(file)) {

            reader.read(inputSequence);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
        return  inputSequence;
    }

    private static void writeUsingFileWriter(String data) {
        // File file = new File("C:\\new/OUTPUT.txt");
        File file = new File("OUTPUT.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        writeUsingFileWriter(findSequence(readUsingFileWriter()));
    }

}
