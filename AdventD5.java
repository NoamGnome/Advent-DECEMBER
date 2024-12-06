import java.io.File;
import java.io.FileNotFoundException;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventD5 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<String> lists = new ArrayList<String>();
        ArrayList<String> rules = new ArrayList<String>();
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).length() > 5) {
                lists.add(fileData.get(i));
            }
        }
        for (int u = 0; u < fileData.size(); u++) {
            if (fileData.get(u).length() == 5) {
                rules.add(fileData.get(u));
            }
        }
        for (int j = 0; j < rules.size(); j++) {
            String before = rules.get(j).substring(0, 2);
            String after = rules.get(j).substring(3);
            
        }
    }
    public static ArrayList<String> getFileData(String fileName) {
        //192
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}