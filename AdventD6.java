import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdventD6 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day6Input.txt");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }
        String location = "";
        for (int o = 0; o < grid.length; o++) {
            for (int j = 0; j < grid[o].length; j++) {
                if (grid[o][j].equals("^")) {
                    location = o + "," + j;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               if (grid[i][j].equals("^")) {

               }
           }
        }


        // "grid" represents a 2D array of Strings built from the input file
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