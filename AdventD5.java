import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventD5 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<String> lists = new ArrayList<String>();
        ArrayList<String> rules = new ArrayList<String>();
        ArrayList<Integer> wrongs = new ArrayList<>();
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
        for (int j = 0; j < lists.size(); j++) {
            System.out.println(lists.get(j));
            for (String rule : rules) {
                int num1 = lists.get(j).indexOf(rule.substring(0, 2));
                int num2 = lists.get(j).indexOf(rule.substring(3, 5));
                if (num1 != -1 && num2 != -1) {
                    if (num1 > num2) {
                        lists.remove(j);
                    }
                }
            }
        }
        System.out.println(lists);
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