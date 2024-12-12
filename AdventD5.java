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
        ArrayList<String> wrongs = new ArrayList<>();
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
        int k = 0;
        while (k != 192) {
            String list = lists.get(k);
            for (int i = 0; i < rules.size(); i++) {
                int firstNum = list.indexOf(rules.get(i).substring(0, 2));
                int secondNum = list.indexOf(rules.get(i).substring(3,5));
                if ((firstNum != -1 && secondNum != -1) && (firstNum > secondNum)) {
                    if (!wrongs.contains(list)) {
                        wrongs.add(list);
                    }
                }
            }
            k++;
        }
        for (int i = 0; i < wrongs.size(); i++) {
            lists.remove(wrongs.get(i));
        }
        int total = 0;
        for (int g = 0; g < lists.size(); g++) {
            total += Integer.parseInt(lists.get(g).substring((lists.get(g).length() / 2) - 1, ((lists.get(g).length() / 2) + 1)));
        }
        System.out.println(total);
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