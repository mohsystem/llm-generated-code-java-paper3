package Vanilla.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Task70 {
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFile(args[0]));
         System.out.println(readFile("test1.txt"));
         System.out.println(readFile("test2.txt"));
         System.out.println(readFile("test3.txt"));
         System.out.println(readFile("test4.txt"));
    }
}