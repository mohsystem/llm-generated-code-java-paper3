package Vanilla.llama31;
public class Task51 {
    public static String encryptString(String message, int r, int c) {
        char[][] matrix = new char[r][c];
        int msgLen = message.length();
        int index = 0;

        // Fill the matrix row-wise
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (index < msgLen) {
                    matrix[i][j] = message.charAt(index++);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        // Read the matrix column-wise
        StringBuilder encrypted = new StringBuilder();
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                encrypted.append(matrix[i][j]);
            }
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "ATTACKATDAWN",
            "HELLO WORLD",
            "ENCRYPTION",
            "SECURITY",
            "PROGRAMMING"
        };
        int[] rows = {3, 3, 3, 3, 3};
        int[] cols = {4, 4, 4, 4, 4};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Original: " + testCases[i]);
            System.out.println("Encrypted: " + encryptString(testCases[i], rows[i], cols[i]));
            System.out.println();
        }
    }
}