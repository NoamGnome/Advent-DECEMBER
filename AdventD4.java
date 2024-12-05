import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdventD4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day4Input.txt");
        // build a 2D Array based on the length of each string and the size of the list
        // e.g
        // ABCD
        // EFGH
        // IJKL
        // This would be a 3 row, 4 column 2D array
        int total = 0;
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }

        // "grid" represents a 2D array of Strings built from the input file
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length - 3; j++) {
                if (grid[i][j].equals("X")) {
                    if (grid[i][j + 1].equals("M")) {
                        if (grid[i][j + 2].equals("A")) {
                            if (grid[i][j + 3].equals("S")) {
                                total++;
                            }
                        }
                    }
                }
            }
        }

        // Forward

        for (int i = 0; i < grid.length; i++) {
            for (int j =  3; j < grid[i].length; j++) {
                if (grid[i][j].equals("X")) {
                    if (grid[i][j - 1].equals("M")) {
                        if (grid[i][j - 2].equals("A")) {
                            if (grid[i][j - 3].equals("S")) {
                                total++;
                            }
                        }
                    }
                }
            }
        }

        //backward

        for (int i = 0; i < grid.length - 3; i++) {
            for (int j =  0; j < grid[i].length; j++) {
                if (grid[i][j].equals("X")) {
                    if (grid[i + 1][j].equals("M")) {
                        if (grid[i + 2][j].equals("A")) {
                            if (grid[i + 3][j].equals("S")) {
                                total++;
                            }
                        }
                    }
                }
            }
        }

        //down

        for (int i = 3; i < grid.length; i++) {
            for (int j =  0; j < grid[i].length; j++) {
                if (grid[i][j].equals("X")) {
                    if (grid[i - 1][j].equals("M")) {
                        if (grid[i - 2][j].equals("A")) {
                            if (grid[i - 3][j].equals("S")) {
                                total++;
                            }
                        }
                    }
                }
            }
        }

        //upwards

        for (int i = 0; i < grid.length - 3; i++) {
            for (int j =  0; j < grid[i].length - 3; j++) {
                if (grid[i][j].equals("X")) {
                    if (grid[i + 1][j + 1].equals("M")) {
                        if (grid[i + 2][j + 2].equals("A")) {
                            if (grid[i + 3][j + 3].equals("S")) {
                                total++;
                            }
                        }
                    }
                }
            }
        }

        //diagonal down right

        for (int i = 0; i < grid.length - 3; i++) {
            for (int j =  3; j < grid[i].length; j++) {
                if (grid[i][j].equals("X")) {
                    if (grid[i + 1][j - 1].equals("M")) {
                        if (grid[i + 2][j - 2].equals("A")) {
                            if (grid[i + 3][j - 3].equals("S")) {
                                total++;
                            }
                        }
                    }
                }
            }
        }

        //diagonal down left

        for (int i = 3; i < grid.length; i++) {
            for (int j =  3; j < grid[i].length; j++) {
                if (grid[i][j].equals("X")) {
                    if (grid[i - 1][j - 1].equals("M")) {
                        if (grid[i - 2][j - 2].equals("A")) {
                            if (grid[i - 3][j - 3].equals("S")) {
                                total++;
                            }
                        }
                    }
                }
            }
        }

        // diagonal up left

        for (int i = 3; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length - 3; j++) {
                if (grid[i][j].equals("X")) {
                    if (grid[i - 1][j + 1].equals("M")) {
                        if (grid[i - 2][j + 2].equals("A")) {
                            if (grid[i - 3][j + 3].equals("S")) {
                                total++;
                            }
                        }
                    }
                }
            }
        }
        // diagonal up right


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