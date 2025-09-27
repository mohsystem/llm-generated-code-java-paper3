package CoT.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Task190 {
    public static String transposeFile(String filename) throws IOException {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(" ");
                List<String> rowList = new ArrayList<>();
                for (String item : row) {
                    rowList.add(item);
                }
                data.add(rowList);
            }
        }

        StringBuilder sb = new StringBuilder();
        int numRows = data.size();
        int numCols = data.get(0).size(); // Assuming all rows have the same number of columns

        for (int j = 0; j < numCols; j++) {
            for (int i = 0; i < numRows; i++) {
                sb.append(data.get(i).get(j));
                if (i < numRows - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String test1 = transposeFile("file1.txt");
        System.out.println(test1);

        String test2 = transposeFile("file2.txt");
        System.out.println(test2);

        String test3 = transposeFile("file3.txt");
        System.out.println(test3);


        String test4 = transposeFile("file4.txt");
        System.out.println(test4);

        String test5 = transposeFile("file5.txt");
        System.out.println(test5);
    }
}