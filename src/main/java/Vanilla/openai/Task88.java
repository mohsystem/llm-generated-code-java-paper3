package Vanilla.openai;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Task88 {
    public static String createUnicodeTempFile(int length) throws IOException {
        int[] pool = new int[] {
            'A','B','C','x','y','z','0','1','2','3',
            0x00E9, // é
            0x03B1, // α
            0x0416, // Ж
            0x4E2D, // 中
            0x6F22, // 漢
            0x3042, // あ
            0x20AC, // €
            0x1F642, // 🙂
            0x1F9E1  // 🧡
        };

        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int cp = pool[rnd.nextInt(pool.length)];
            sb.appendCodePoint(cp);
        }
        String randomStr = sb.toString();

        StringBuilder uni = new StringBuilder();
        randomStr.codePoints().forEach(cp -> {
            if (uni.length() > 0) uni.append(' ');
            String hex = Integer.toHexString(cp).toUpperCase();
            int width = (cp <= 0xFFFF) ? 4 : 6;
            while (hex.length() < width) hex = "0" + hex;
            uni.append("U+").append(hex);
        });

        String content = randomStr + System.lineSeparator() + uni.toString();

        Path tmp = Files.createTempFile("task88_", ".txt");
        Files.writeString(tmp, content, StandardCharsets.UTF_8);
        return tmp.toAbsolutePath().toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(createUnicodeTempFile(8));
        System.out.println(createUnicodeTempFile(10));
        System.out.println(createUnicodeTempFile(12));
        System.out.println(createUnicodeTempFile(14));
        System.out.println(createUnicodeTempFile(16));
    }
}