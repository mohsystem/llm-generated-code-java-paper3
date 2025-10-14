package Vanilla.openai;
import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class Task100 {
    public static boolean searchFileWithRegex(String regex, String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            return matcher.find();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(searchFileWithRegex("pattern1", "test1.txt"));
        System.out.println(searchFileWithRegex("pattern2", "test2.txt"));
        System.out.println(searchFileWithRegex("pattern3", "test3.txt"));
        System.out.println(searchFileWithRegex("pattern4", "test4.txt"));
        System.out.println(searchFileWithRegex("pattern5", "test5.txt"));
    }
}