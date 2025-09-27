package Vanilla.gemini;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

class Task52 {

    private static final byte[] KEY = {1, 2, 3, 4, 5};

    public static void encryptFile(String inputFile, String outputFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                byte[] encryptedBuffer = encrypt(Arrays.copyOf(buffer, bytesRead));
                fos.write(encryptedBuffer);
            }
        }
    }

    public static void decryptFile(String inputFile, String outputFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                byte[] decryptedBuffer = decrypt(Arrays.copyOf(buffer, bytesRead));
                fos.write(decryptedBuffer);
            }
        }
    }

    private static byte[] encrypt(byte[] data) {
        byte[] encryptedData = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            encryptedData[i] = (byte) (data[i] ^ KEY[i % KEY.length]);
        }
        return encryptedData;
    }

    private static byte[] decrypt(byte[] data) {
        return encrypt(data); // XOR is symmetric
    }

    public static void main(String[] args) throws IOException {
        encryptFile("test1.txt", "test1.enc");
        decryptFile("test1.enc", "test1.dec");

        encryptFile("test2.txt", "test2.enc");
        decryptFile("test2.enc", "test2.dec");

        encryptFile("test3.txt", "test3.enc");
        decryptFile("test3.enc", "test3.dec");

        encryptFile("test4.txt", "test4.enc");
        decryptFile("test4.enc", "test4.dec");

        encryptFile("test5.txt", "test5.enc");
        decryptFile("test5.enc", "test5.dec");


    }
}