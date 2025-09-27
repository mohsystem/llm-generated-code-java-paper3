package CoT.claude;

public class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        if (numbers == null || numbers.length != 10) {
            return "";
        }
        
        for (int num : numbers) {
            if (num < 0 || num > 9) {
                return "";
            }
        }
        
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
            numbers[0], numbers[1], numbers[2], numbers[3], numbers[4],
            numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(createPhoneNumber(new int[]{1,2,3,4,5,6,7,8,9,0})); // "(123) 456-7890"
        System.out.println(createPhoneNumber(new int[]{9,9,9,8,8,8,7,7,7,6})); // "(999) 888-7776"
        System.out.println(createPhoneNumber(new int[]{0,1,2,3,4,5,6,7,8,9})); // "(012) 345-6789"
        System.out.println(createPhoneNumber(new int[]{5,5,5,4,4,4,3,3,3,2})); // "(555) 444-3332"
        System.out.println(createPhoneNumber(new int[]{1,1,1,1,1,1,1,1,1,1})); // "(111) 111-1111"
    }
}
