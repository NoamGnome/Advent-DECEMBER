
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventD2P2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        int total = 1000;
        ArrayList<String> wrongs = new ArrayList<>();
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
                if (!wrongs.contains(fileData.get(i))) {
                    wrongs.add(fileData.get(i));
                }
            }
        }
        System.out.println(wrongs.size());
        ArrayList<String> correctness = new ArrayList<>();
        for (int i = 0; i < wrongs.size(); i++) {
            String[] integers = wrongs.get(i).split(" ");
            ArrayList<Integer> news = new ArrayList<>();
            for (String s : integers) {
                news.add(Integer.parseInt(s));
            }
            for (int j = 0; j < integers.length; j++) {
                boolean increasing = true;
                boolean decreasing = true;
                boolean match = true;
                ArrayList<Integer> news1 = new ArrayList<>(news);
                news1.remove(j);
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
                }
                if (match) {
                    if (!correctness.contains(wrongs.get(i))) {
                        correctness.add(wrongs.get(i));
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
