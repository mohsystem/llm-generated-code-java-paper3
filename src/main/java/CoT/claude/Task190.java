package CoT.claude;

import java.io.*;
import java.util.*;

public class Task190 {
    public static List<String> transposeFile(String filename) {
        List<String> result = new ArrayList<>();
        try {
            List<String[]> rows = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(line.split(" "));
            }
            br.close();
            
            if (rows.size() == 0) return result;
            
            int rowCount = rows.size();
            int colCount = rows.get(0).length;
            
            for (int j = 0; j < colCount; j++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < rowCount; i++) {
                    sb.append(rows.get(i)[j]);
                    if (i < rowCount - 1) sb.append(" ");
                }
                result.add(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Test case 1
            FileWriter fw = new FileWriter("file1.txt");
            fw.write("name age\\nalice 21\\nryan 30");
            fw.close();
            System.out.println("Test 1: " + transposeFile("file1.txt"));

            // Test case 2
            fw = new FileWriter("file2.txt");
            fw.write("a b c\\n1 2 3\\nx y z");
            fw.close();
            System.out.println("Test 2: " + transposeFile("file2.txt"));

            // Test case 3
            fw = new FileWriter("file3.txt");
            fw.write("col1 col2\\nval1 val2");
            fw.close();
            System.out.println("Test 3: " + transposeFile("file3.txt"));

            // Test case 4
            fw = new FileWriter("file4.txt");
            fw.write("single");
            fw.close();
            System.out.println("Test 4: " + transposeFile("file4.txt"));

            // Test case 5
            fw = new FileWriter("file5.txt");
            fw.write("");
            fw.close();
            System.out.println("Test 5: " + transposeFile("file5.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
