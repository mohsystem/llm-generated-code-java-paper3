package Vanilla.gpt4o;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Task121 {

    public List<String> uploadFiles(List<String> filePaths) {
        List<String> uploadedFiles = new ArrayList<>();
        for (String path : filePaths) {
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                // Simulate file upload
                uploadedFiles.add(file.getName());
            }
        }
        return uploadedFiles;
    }

    public static void main(String[] args) {
        Task121 task = new Task121();
        List<String> files = new ArrayList<>();
        files.add("path/to/file1.txt");
        files.add("path/to/file2.txt");
        files.add("path/to/file3.txt");
        files.add("path/to/file4.txt");
        files.add("path/to/file5.txt");

        List<String> uploadedFiles = task.uploadFiles(files);
        System.out.println("Uploaded Files: " + uploadedFiles);
    }
}