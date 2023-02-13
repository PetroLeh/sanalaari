package app;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {    
    public static ArrayList<String> asList(String file) {
        ArrayList<String> lines = new ArrayList<>();
            try {
                File f = new File(file);
                Scanner reader = new Scanner(f);
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    lines.add(line);        
                }
                reader.close();
            } catch(Exception e) {
                System.out.println("Error reading file " + file + ":\n" + e.getMessage());
            }
        return lines;
    }
}
