package Vanilla.codestral;
import java.io.*;
import java.nio.file.*;

public class Task127 {
    public static void copyFile(String source, String destination) {
        try {
            Files.copy(Paths.get(source), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("An error occurred while copying the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        copyFile("source_file_path", "destination_file_path");
    }
}