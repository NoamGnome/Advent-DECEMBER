import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AdventD3 {
    public static void main(String[] args) {
        int total = 0;
        String regex = "mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)";
        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        ArrayList<String> allMatches = new ArrayList<String>();
        for (int i = 0; i < fileData.size(); i++) {
            Matcher m = Pattern.compile(regex).matcher(fileData.get(i));
            while (m.find()) {
                allMatches.add(m.group());
            }
        }
        for (int i = 0; i < allMatches.size(); i++) {
            int num1 = Integer.parseInt(allMatches.get(i).substring(4, allMatches.get(i).indexOf(",")));
            int num2 = Integer.parseInt(allMatches.get(i).substring(allMatches.get(i).indexOf(",") + 1, allMatches.get(i).length() - 1));
            total += num1 * num2;
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