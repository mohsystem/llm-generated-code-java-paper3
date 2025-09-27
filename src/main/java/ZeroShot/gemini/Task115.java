package ZeroShot.gemini;
public class Task115 {

    static class PackedData {
        int val1 = 4;
        int val2 = 6;
        int val3 = 8;
    }

    public static String packData(int v1, int v2, int v3) {
        PackedData data = new PackedData();
        data.val1 = v1;
        data.val2 = v2;
        data.val3 = v3;

        return String.format("val1: %d, val2: %d, val3: %d", data.val1, data.val2, data.val3);

    }

    public static void main(String[] args) {
        System.out.println(packData(1, 2, 3));
        System.out.println(packData(15, 63, 255));
        System.out.println(packData(0, 0, 0));
        System.out.println(packData(7, 31, 127));
        System.out.println(packData(-1, -1, -1)); // Demonstrates wrapping behavior
    }
}