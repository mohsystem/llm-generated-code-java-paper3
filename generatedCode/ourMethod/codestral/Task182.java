package ourMethod.codestral;
public class Task182 {
    public static String cleanPhoneNumber(String number) {
        return number.replaceAll("[^\\d]", "");
    }

    public static void main(String[] args) {
        String[] numbers = {"+1 (613)-995-0253", "613-995-0253", "1 613 995 0253", "613.995.0253"};
        for (String number : numbers) {
            System.out.println(cleanPhoneNumber(number));
        }
    }
}