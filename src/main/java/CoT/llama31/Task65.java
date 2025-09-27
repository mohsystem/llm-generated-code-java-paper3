package CoT.llama31;
public class Task65 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task65 <filename>");
            return;
        }
        String filename = args[0];
        try {
            java.io.File file = new java.io.File(filename);
            if (!file.exists() || !file.isFile()) {
                System.out.println("File does not exist or is not a file.");
                return;
            }
            java.util.Scanner scanner = new java.util.Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void testCases() {
        String[] testFiles = {"existingFile.txt", "nonExistingFile.txt", "invalidFile", "", null};
        for (String file : testFiles) {
            if (file != null) {
                System.out.println("Testing with file: " + file);
                try {
                    java.io.File f = new java.io.File(file);
                    if (!f.exists() || !f.isFile()) {
                        System.out.println("File does not exist or is not a file.");
                    } else {
                        java.util.Scanner scanner = new java.util.Scanner(f);
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                        scanner.close();
                    }
                } catch (java.io.FileNotFoundException e) {
                    System.out.println("File not found: " + e.getMessage());
                } catch (java.io.IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            } else {
                System.out.println("File is null.");
            }
        }
    }
//
//    public static void main(String[] args) {
//        main(args);
//        testCases();
//    }
}