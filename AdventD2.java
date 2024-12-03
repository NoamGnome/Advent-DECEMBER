import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdventD2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        int total = 1000;
        for (int i = 0; i < fileData.size(); i++) {
            boolean increasing = true;
            boolean decreasing = true;
            boolean match = true;
            for (int j = 1; j < fileData.get(i).split(" ").length; j++) {
                int integer = Integer.parseInt(fileData.get(i).split(" ")[j]);
                int integer1 = Integer.parseInt(fileData.get(i).split(" ")[j - 1]);
                if (Math.abs(integer - integer1) < 1 || Math.abs(integer - integer1) > 3) {
                    match = false;
                }
                if (integer < integer1) {
                    increasing = false;
                }
                if (integer > integer1) {
                    decreasing = false;
                }
                if (!increasing && !decreasing) {
                    match = false;
                }
            }
            if (!match) {
                total--;
            }
        }
        System.out.println(total);
    }

    public static ArrayList<String> getFileData(String fileName) {
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