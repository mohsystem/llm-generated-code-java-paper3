package Vanilla.claude;

import java.io.*;
import java.nio.file.*;

public class Task52 {
    public static byte[] encrypt(byte[] data, byte key) {
        byte[] encrypted = new byte[data.length];
        for(int i = 0; i < data.length; i++) {
            encrypted[i] = (byte)(data[i] ^ key);
        }
        return encrypted;
    }
    
    public static byte[] decrypt(byte[] data, byte key) {
        return encrypt(data, key); // XOR encryption is reversible
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Simple text file
            String content1 = "Hello World";
            Files.write(Paths.get("test1.txt"), content1.getBytes());
            byte[] data1 = Files.readAllBytes(Paths.get("test1.txt"));
            byte[] encrypted1 = encrypt(data1, (byte)0x0F);
            Files.write(Paths.get("encrypted1.txt"), encrypted1);
            byte[] decrypted1 = decrypt(encrypted1, (byte)0x0F);
            System.out.println("Test 1: " + new String(decrypted1));

            // Test case 2: Empty file
            Files.write(Paths.get("test2.txt"), new byte[0]);
            byte[] data2 = Files.readAllBytes(Paths.get("test2.txt"));
            byte[] encrypted2 = encrypt(data2, (byte)0x0F);
            Files.write(Paths.get("encrypted2.txt"), encrypted2);
            byte[] decrypted2 = decrypt(encrypted2, (byte)0x0F);
            System.out.println("Test 2: " + new String(decrypted2));

            // Test case 3: Special characters
            String content3 = "!@#$%^&*()";
            Files.write(Paths.get("test3.txt"), content3.getBytes());
            byte[] data3 = Files.readAllBytes(Paths.get("test3.txt"));
            byte[] encrypted3 = encrypt(data3, (byte)0x0F);
            Files.write(Paths.get("encrypted3.txt"), encrypted3);
            byte[] decrypted3 = decrypt(encrypted3, (byte)0x0F);
            System.out.println("Test 3: " + new String(decrypted3));

            // Test case 4: Numbers
            String content4 = "12345";
            Files.write(Paths.get("test4.txt"), content4.getBytes());
            byte[] data4 = Files.readAllBytes(Paths.get("test4.txt"));
            byte[] encrypted4 = encrypt(data4, (byte)0x0F);
            Files.write(Paths.get("encrypted4.txt"), encrypted4);
            byte[] decrypted4 = decrypt(encrypted4, (byte)0x0F);
            System.out.println("Test 4: " + new String(decrypted4));

            // Test case 5: Long text
            String content5 = "This is a longer text to test encryption and decryption";
            Files.write(Paths.get("test5.txt"), content5.getBytes());
            byte[] data5 = Files.readAllBytes(Paths.get("test5.txt"));
            byte[] encrypted5 = encrypt(data5, (byte)0x0F);
            Files.write(Paths.get("encrypted5.txt"), encrypted5);
            byte[] decrypted5 = decrypt(encrypted5, (byte)0x0F);
            System.out.println("Test 5: " + new String(decrypted5));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
