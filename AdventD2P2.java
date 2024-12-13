
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdventD2P2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        int total = 1000;
        for (int i = 0; i < fileData.size(); i++) {
            String[] integers = fileData.get(i).split(" ");
            for (int j = 0; j < integers.length; j++) {
                ArrayList<Integer> news = new ArrayList<>();
                ArrayList<Integer> news1 = new ArrayList<>();
                news.add(Integer.parseInt(integers[j]));
                for (int k = 0; k < news.size(); k++) {
                    news1.add(k);
                }
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
