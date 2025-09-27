package ourMethod.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

class Task0 {

    private static final String SHARED_DIRECTORY = "shared_directory";

    public static void processFiles(String directory) throws InterruptedException, IOException {
        BlockingQueue<Path> fileQueue = new LinkedBlockingQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        // Create the shared directory if it doesn't exist
        File sharedDir = new File(directory);
        if (!sharedDir.exists()) {
            sharedDir.mkdir();
        }

        List<Path> files = Files.list(Paths.get(directory))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

        for (Path file : files) {
            fileQueue.put(file);
        }

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            executor.submit(() -> {
                try {
                    while (true) {
                        Path file = fileQueue.poll(1, TimeUnit.SECONDS);
                        if (file == null) break; // Exit when queue is empty

                        synchronized (file.toAbsolutePath().toString().intern()) { // Lock on file path
                            // Process the file
                            List<String> lines = Files.readAllLines(file);
                            // Example processing: print file name and number of lines
                            System.out.println("Processing file: " + file.getFileName() + ", Lines: " + lines.size());
                        }
                    }
                } catch (InterruptedException | IOException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Finished processing all files.");
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        // Test cases
        createTestFiles(SHARED_DIRECTORY, 5);
        processFiles(SHARED_DIRECTORY);


        createTestFiles(SHARED_DIRECTORY, 10);
        processFiles(SHARED_DIRECTORY);


        createTestFiles(SHARED_DIRECTORY, 1);
        processFiles(SHARED_DIRECTORY);



        createTestFiles(SHARED_DIRECTORY, 20);
        processFiles(SHARED_DIRECTORY);



        createTestFiles(SHARED_DIRECTORY, 0);
        processFiles(SHARED_DIRECTORY);




    }

    private static void createTestFiles(String directory, int numFiles) throws IOException {
        // Delete existing files for testing purposes
        for (File file : new File(directory).listFiles())
                if (file.isFile()) file.delete();


        for (int i = 0; i < numFiles; i++) {
            Path file = Paths.get(directory, "file" + i + ".txt");
            Files.write(file, ("Content of file " + i).getBytes());
        }
    }
}