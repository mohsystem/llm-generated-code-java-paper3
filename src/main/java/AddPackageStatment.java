import java.io.*;
import java.nio.file.*;

public class AddPackageStatment {
    static String promptType = "ZeroShot"; //this is the name of the root directory

    public static void main(String[] args) {
        // Replace with the directory path where your folders and files are located
        String rootDirectoryPath = "generatedCode/" + promptType;

        File rootDirectory = new File(rootDirectoryPath);
        if (!rootDirectory.isDirectory()) {
            System.out.println("Invalid directory path provided.");
            return;
        }

        processDirectory(rootDirectory);
    }

    private static void processDirectory(File directory) {
        // Get all files and subdirectories in the current directory
        File[] filesAndDirs = directory.listFiles();
        if (filesAndDirs == null) return;

        for (File fileOrDir : filesAndDirs) {
            if (fileOrDir.isDirectory()) {
                // Recursive call for subdirectories
                processDirectory(fileOrDir);
            } else {
                // Process the file
                prependFolderNameToFile(fileOrDir, directory.getName());
            }
        }
    }

    private static void prependFolderNameToFile(File file, String folderName) {
        try {
            // Read the current content of the file
            String fileContent = new String(Files.readAllBytes(file.toPath()));

            // Prepend the folder name
            String updatedContent = "package " + promptType + "." + folderName + ";\n" + fileContent;

            // Write the updated content back to the file
            Files.write(file.toPath(), updatedContent.getBytes());

            System.out.println("Updated file: " + file.getPath());
        } catch (IOException e) {
            System.err.println("Failed to process file: " + file.getPath());
            e.printStackTrace();
        }
    }
}
