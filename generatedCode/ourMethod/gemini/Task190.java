package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task190 {

    public static String transposeFile(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(" "));
            }
        }

        if (data.isEmpty() || data.get(0).length == 0) {
            return "";
        }


        int rows = data.size();
        int cols = data.get(0).length;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                sb.append(data.get(i)[j]);
                if (i < rows - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString().trim();
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