import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class AdventD1 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        int total = 0;

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        for (int i = 0; i < fileData.size(); i++) {
            list1.add((fileData.get(i).split("   ")[0]));
            list2.add(fileData.get(i).split("   ")[1]);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for (int h = 0; h < fileData.size(); h++) {
            total += Math.abs(Integer.parseInt(list1.get(h)) - Integer.parseInt(list2.get(h)));
        }
        System.out.println(total);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> list1 = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    list1.add(line);
            }
            return list1;
        }
        catch (FileNotFoundException e) {
            return list1;
        }
    }
}