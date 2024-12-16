

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventD2P2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        ArrayList<String> correctness = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            String[] integers = fileData.get(i).split(" ");
            ArrayList<Integer> news = new ArrayList<>();
            for (String s : integers) {
                news.add(Integer.parseInt(s));
            }
            System.out.println(news);
            for (int j = 0; j < integers.length; j++) {
                boolean increasing = true;
                boolean decreasing = true;
                boolean match = true;
                ArrayList<Integer> news1 = new ArrayList<>(news);
                news1.remove(j);
                System.out.println(news1);
                for (int k = 1; k < news1.size(); k++) {
                    int integer = news1.get(k);
                    int integer1 = news1.get(k - 1);
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
                    if (match) {
                        if (!correctness.contains(fileData.get(i))) {
                            correctness.add(fileData.get(i));
                        }
                    }
                }
            }
        }
        System.out.println(correctness.size());
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
