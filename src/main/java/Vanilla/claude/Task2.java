package Vanilla.claude;

public class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
            numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], 
            numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }
    
    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[]{1,2,3,4,5,6,7,8,9,0}));
        System.out.println(createPhoneNumber(new int[]{9,9,9,8,8,8,7,7,7,6}));
        System.out.println(createPhoneNumber(new int[]{0,1,2,3,4,5,6,7,8,9}));
        System.out.println(createPhoneNumber(new int[]{1,1,1,2,2,2,3,3,3,4}));
        System.out.println(createPhoneNumber(new int[]{5,5,5,4,4,4,3,3,3,2}));
    }
}
