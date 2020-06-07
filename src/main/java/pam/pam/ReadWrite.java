package pam.pam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {
    public static void toWrite(String sentence, String patchToFile) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(patchToFile);
            System.out.println("text to write: " + sentence + "\nin file: " + patchToFile);
            fileWriter.write(sentence);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR\nUnable to write file " + patchToFile);
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String toRead(String patchToFile) {
        BufferedReader fileReader = null;
        String sentence = null;
        try {
            fileReader = new BufferedReader(new FileReader(patchToFile));
            sentence = fileReader.readLine();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("ERROR\nUnable to read file " + patchToFile);
            e.printStackTrace();
            System.exit(1);
        }
        if (sentence == null) {
            System.out.println("file is empty");
            System.exit(1);
        }
        return sentence;
    }
}
