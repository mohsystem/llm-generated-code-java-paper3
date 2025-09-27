package ZeroShot.gemini;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task190 {
    public static String transpose(String filename) throws FileNotFoundException {
        List<List<String>> data = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            data.add(Arrays.asList(line.split(" ")));
        }
        scanner.close();

        StringBuilder sb = new StringBuilder();
        int rows = data.size();
        int cols = data.get(0).size();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                sb.append(data.get(i).get(j));
                if (i < rows - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(transpose("file1.txt"));
        System.out.println(transpose("file2.txt"));
        System.out.println(transpose("file3.txt"));
        System.out.println(transpose("file4.txt"));
        System.out.println(transpose("file5.txt"));
    }
}